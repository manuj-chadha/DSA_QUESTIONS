class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+1][2];
        dp[n][1]=0;
        dp[n][0]=0;
        for(int i=n-1;i>=0;i--){
            int buy=dp[i+1][1] - prices[i];
            int notBuy=dp[i+1][0];
            dp[i][0]=Math.max(buy, notBuy);

            int sell=dp[i+1][0] + prices[i];
            int notSell=dp[i+1][1];
            dp[i][1]=Math.max(sell, notSell);
        }
        return dp[0][0];
    }
}