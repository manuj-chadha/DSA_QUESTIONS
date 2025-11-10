class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        int even=0;
        int odd=1;
        int i=0;
        while(i<n){
            if(nums[i]<0){
                ans[odd]=nums[i];
                odd+=2;
            }
            else {
                ans[even]=nums[i];
                even+=2;
            }
            i++;
        }
        return ans;
    }
}