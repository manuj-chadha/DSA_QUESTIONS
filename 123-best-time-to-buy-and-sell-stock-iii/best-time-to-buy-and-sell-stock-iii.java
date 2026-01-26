class Solution {
    int[][][] dp;
    public int maxProfit(int[] prices) {
        dp=new int[prices.length][2][3];
        for(int[][] nums: dp){
            for(int[] num : nums) Arrays.fill(num, -1);
        } 
        return maxProfit(prices, 0, 1, 0);
    }
    private int maxProfit(int[] nums, int i, int canBuy, int k) {
        if(k==2) return 0;
        if(i==nums.length) return 0;
        if(dp[i][canBuy][k]!=-1) return dp[i][canBuy][k];
        if(canBuy==1) {
            return dp[i][canBuy][k]= Math.max(maxProfit(nums, i+1, 0, k)-nums[i], maxProfit(nums, i+1, 1, k));
        }
        return dp[i][canBuy][k]=Math.max(maxProfit(nums, i+1, 1, k+1)+nums[i], maxProfit(nums, i+1, 0, k));
    }
}