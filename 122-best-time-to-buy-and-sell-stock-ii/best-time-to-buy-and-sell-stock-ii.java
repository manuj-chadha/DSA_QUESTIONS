class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][2];
        dp[0][1]=0;
        dp[0][0]=-prices[0];
        for(int i=1;i<prices.length;i++){
            int buy=dp[i-1][1] - prices[i];
            int notBuy=dp[i-1][0];
            dp[i][0]=Math.max(buy, notBuy);

            int sell=dp[i-1][0] + prices[i];
            int notSell=dp[i-1][1];
            dp[i][1]=Math.max(sell, notSell);
        }
        return dp[prices.length-1][1];
    }
}