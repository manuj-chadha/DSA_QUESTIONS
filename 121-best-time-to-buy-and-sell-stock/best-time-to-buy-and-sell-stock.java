class Solution {
    public int maxProfit(int[] prices) {
        int buy=Integer.MAX_VALUE;
        int sell=0;
        for(int num: prices) {
            buy=Math.min(buy, num);
            if((num-buy)>sell){
                sell=num-buy;
            }
        }
        return sell;
    }
}