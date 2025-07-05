class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int len=cost.length;
        dp=new int[len];
        dp[len-1]=cost[len-1];
        dp[len-2]=cost[len-2];
        for(int index=cost.length-3;index>=0;index--){
            dp[index]=Math.min(dp[index+1], dp[index+2])+cost[index];
        }
        return Math.min(dp[0], dp[1]);
    }
}