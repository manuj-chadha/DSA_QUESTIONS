class Solution {
    int[][] dp;
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        dp=new int[m+2][m+2];
        for(int[] i: dp) Arrays.fill(i, -1);
        int[] cut=new int[m+2];
        cut[0]=0;
        cut[m+1]=n;
        System.arraycopy(cuts, 0, cut, 1, m);
        Arrays.sort(cut);
        return minCost(cut, 1, m);
    }
    private int minCost(int[] arr, int i, int j){
        if(i>j) return 0;

        if(dp[i][j]!=-1) return dp[i][j];
        int mini=Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int cost=arr[j+1]-arr[i-1]+minCost(arr, i, k-1)+minCost(arr, k+1, j);
            mini=Math.min(mini, cost);
        }
        return dp[i][j]=mini;
    }
}