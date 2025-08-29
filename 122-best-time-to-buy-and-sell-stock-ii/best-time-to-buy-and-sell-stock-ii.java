class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[] prev=new int[2];
        
        for(int i=n-1;i>=0;i--){
            int[] curr=new int[2];
            int buy=prev[1] - prices[i];
            int notBuy=prev[0];
            curr[0]=Math.max(buy, notBuy);

            int sell=prev[0] + prices[i];
            int notSell=prev[1];
            curr[1]=Math.max(sell, notSell);

            prev=curr;
        }
        return prev[0];
    }
}