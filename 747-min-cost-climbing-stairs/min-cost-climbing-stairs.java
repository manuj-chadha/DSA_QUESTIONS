class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        dp=new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(cost(cost, 0), cost(cost, 1));
    }
    int cost(int[] cost, int index){
        if(index>=cost.length) return 0;
        if(dp[index]!=-1) return dp[index];
        return dp[index]=Math.min(cost(cost, index+1), cost(cost, index+2))+cost[index];
    }
}