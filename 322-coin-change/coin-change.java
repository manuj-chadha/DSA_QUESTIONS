class Solution {
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        dp=new int[amount+1];
        Arrays.fill(dp, -1);
        int val=coins(coins, amount);
        return val==Integer.MAX_VALUE ? -1 : val;
    }
    private int coins(int[] nums, int amount){
        if(amount==0) return 0;
        if(dp[amount]!=-1) return dp[amount];
        int min=Integer.MAX_VALUE;
        for(int num: nums){
            if(num<=amount){
                min=Math.min(coins(nums, amount-num), min);
            }
        }
        return dp[amount]=min==Integer.MAX_VALUE ? min: min+1;
    }
}