class Solution {
    public int findMin(int[] nums) {
        int len=nums.length;
        if(nums[0]<nums[len-1]) return nums[0];
        int start=0;
        int end=len-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]>nums[len-1]) start=mid+1;
            else end=mid-1;
        }
        return nums[start];
    }
}