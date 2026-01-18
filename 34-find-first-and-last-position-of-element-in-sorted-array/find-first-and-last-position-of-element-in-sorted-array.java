class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=binarySearch(nums, target, 0);
        int last=binarySearch(nums, target, 1);
        return new int[]{first, last};
    }
    private int binarySearch(int[] nums, int target, int type){
        int start=0;
        int end=nums.length-1;
        int occ=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(type==0){
                if(nums[mid]>=target){
                    if(nums[mid]==target) occ=mid;
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            else if(type==1){
                if(nums[mid]>target){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                    if(nums[mid]==target) occ=mid;
                }
            }
        }
        return occ;
    }
}