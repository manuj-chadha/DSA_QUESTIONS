class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        dp=new int[prices.length][2];
        for(int[] num: dp) Arrays.fill(num, -1);
        return findProfit(prices, 0, 1);
    }
    private int findProfit(int[] nums, int i, int canBuy){
        if(i==nums.length) return 0;
        if(dp[i][canBuy]!=-1) return dp[i][canBuy];
        if(canBuy==1){
            return dp[i][canBuy]=Math.max(findProfit(nums, i+1, 0)-nums[i], findProfit(nums, i+1, 1));
        }
        return dp[i][canBuy]=Math.max(findProfit(nums, i+1, 1)+nums[i], findProfit(nums, i+1, 0));
    }
}