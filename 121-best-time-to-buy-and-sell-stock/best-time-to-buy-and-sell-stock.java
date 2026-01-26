class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int max=0;
        for(int num: prices) {
            if(num>min){
                max=Math.max(max, num-min);
            }
            else {
                min=num;
            }
        }
        return max;
    }
}