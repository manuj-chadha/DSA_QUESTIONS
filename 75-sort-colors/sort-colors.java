class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int zero=0;
        int two=n-1;

        int i=0;
        while(i<=two){
            if(nums[i]==1) i++;
            else if(nums[i]==0){
                swap(nums, zero, i);
                zero++;
                i++;
            }
            else {
                swap(nums, two, i);
                two--;
            }
        }
    }
    private void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}