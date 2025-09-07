class Solution {
    int[][] dp;
    public int minCost(int n, int[] cuts) {
        int m=cuts.length;
        dp=new int[m+2][m+2];
        int[] cut=new int[m+2];
        cut[0]=0;
        cut[m+1]=n;
        Arrays.sort(cuts);
        System.arraycopy(cuts, 0, cut, 1, m);
        for(int i=m;i>0;i--){
            for(int j=i;j<=m;j++){
                int mini=Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    int cost=cut[j+1]-cut[i-1]+dp[i][k-1]+dp[k+1][j];
                    mini=Math.min(mini, cost);
                }
                dp[i][j]=mini;
            }
        }
        return dp[1][m];
    }
}