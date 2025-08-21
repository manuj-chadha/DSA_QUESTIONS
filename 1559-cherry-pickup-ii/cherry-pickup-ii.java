class Solution {
    int[][][] dp;
    public int cherryPickup(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        dp=new int[rows][cols][cols];
        for(int i=0;i<cols;i++){
            for(int j=0;j<cols;j++){
                if(i==j) dp[rows-1][i][j]=grid[rows-1][i];
                else dp[rows-1][i][j]=grid[rows-1][i]+grid[rows-1][j];
            }
        }
        
        for(int row=rows-2;row>=0;row--){
            for(int i=0;i<cols;i++){
                for(int j=0;j<cols;j++){
                    int result=Integer.MIN_VALUE;
                    for(int r=-1;r<2;r++){
                        for(int c=-1;c<2;c++){
                            if((i+r)>=0 && (i+r)<cols && (j+c)>=0 && (j+c)<cols) {
                                result=Math.max(result, dp[row+1][i+r][j+c]);
                            }
                        }
                    }
                    if(i==j) dp[row][i][j]=grid[row][i]+result;
                    else dp[row][i][j]=grid[row][i]+grid[row][j]+result;
                }
            }
        }
        return dp[0][0][cols-1];
    }
}