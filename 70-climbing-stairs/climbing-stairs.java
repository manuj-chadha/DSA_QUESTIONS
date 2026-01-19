class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp=new int[n+1];
        Arrays.fill(dp, -1);
        return totalWays(n);
    }
    private int totalWays(int n){
        if(n==0 || n==1) return 1;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=totalWays(n-1)+totalWays(n-2);
    }
}