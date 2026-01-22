class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        dp=new int[nums.length][nums.length+1];
        for(int[] d: dp){
            Arrays.fill(d, -1);
        }
        return lengthOfLIS(nums, 0, -1);
    }
    private int lengthOfLIS(int[] nums, int i, int prev){
        if(i>=nums.length) return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        if(prev==-1 || nums[i]>nums[prev] ){
            return dp[i][prev+1]=Math.max(1+lengthOfLIS(nums, i+1, i), lengthOfLIS(nums, i+1, prev));
        }
        return dp[i][prev+1]=lengthOfLIS(nums, i+1, prev);
    }
}