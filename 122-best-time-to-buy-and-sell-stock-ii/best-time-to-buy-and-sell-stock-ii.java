class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        dp=new int[prices.length][2];
        for(int[] i: dp) Arrays.fill(i, -1);

        return maxProfit(prices, 0, 1);
    }
    private int maxProfit(int[] prices, int index, int ableToBuy){
        if(index==prices.length) return 0;
        if(dp[index][ableToBuy]!=-1) return dp[index][ableToBuy];
        if(ableToBuy==1){
            int buy=maxProfit(prices, index+1, 0) - prices[index];
            int notBuy=maxProfit(prices, index+1, 1);
            return dp[index][ableToBuy]=Math.max(buy, notBuy);
        }
        else {
            int sell=maxProfit(prices, index+1, 1) + prices[index];
            int notSell=maxProfit(prices, index+1, 0);
            return dp[index][ableToBuy]=Math.max(sell, notSell);
        }
    }
}