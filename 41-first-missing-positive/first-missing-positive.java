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
            if(nums[i]-1!=i) return i+1;
        }
        return nums.length+1;
    }
    private void swap(int[] nums, int s, int e){
        int temp=nums[s];
        nums[s]=nums[e];
        nums[e]=temp;
    }
}