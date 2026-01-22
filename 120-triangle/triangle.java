class Solution {
    int[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        dp=new int[n][n];
        for(int i=0;i<n;i++) dp[n-1][i]=triangle.get(n-1).get(i);
        for(int row=triangle.size()-2;row>=0;row--){
            for(int col=0;col<=row;col++){
                dp[row][col]=Math.min(dp[row+1][col], dp[row+1][col+1])+triangle.get(row).get(col);
            }
        }
        return dp[0][0];
    }
}