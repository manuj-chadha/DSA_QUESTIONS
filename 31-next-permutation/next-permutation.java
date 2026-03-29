class Solution {
    public void nextPermutation(int[] nums) {
        int i=nums.length-2;
        while(i>=0){
            if(nums[i]<nums[i+1]){
                break;
            }
            else i--;
        }
        if(i<0){
            reverse(nums, 0, nums.length-1);
            return;
        }
        for(int j=nums.length-1;j>i;j--){
            if(nums[j]>nums[i]){
                swap(nums, i, j);
                reverse(nums, i+1, nums.length-1);
                break;
            }
        }
    }
    private void reverse(int[] nums, int i, int j){
        while(i<j){
            swap(nums, i++,j--);
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}