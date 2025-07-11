class Solution {
    public int firstMissingPositive(int[] nums) {
        int end=0;
        while(end<nums.length){
            int index=nums[end]-1;
            if(nums[end]>0 && nums[end]<=nums.length && nums[end]!=nums[index]){
                swap(nums, end, index);
            }
            else {
                end++;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1) return i+1;
        }
        return nums.length+1;
    }
    public void swap(int[] arr, int f, int s){
        int temp=arr[f];
        arr[f]=arr[s];
        arr[s]=temp;
    }
}