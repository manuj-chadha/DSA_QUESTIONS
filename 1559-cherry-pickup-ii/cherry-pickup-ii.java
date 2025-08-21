class Solution {
    public int cherryPickup(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int[][] dp=new int[cols][cols];
        for(int i=0;i<cols;i++){
            for(int j=0;j<cols;j++){
                if(i==j) dp[i][j]=grid[rows-1][i];
                else dp[i][j]=grid[rows-1][i]+grid[rows-1][j];
            }
        }
        
        for(int row=rows-2;row>=0;row--){
            int[][] curr=new int[cols][cols];
            for(int i=0;i<cols;i++){
                for(int j=0;j<cols;j++){
                    int result=Integer.MIN_VALUE;
                    for(int r=-1;r<2;r++){
                        for(int c=-1;c<2;c++){
                            if((i+r)>=0 && (i+r)<cols && (j+c)>=0 && (j+c)<cols) {
                                result=Math.max(result, dp[i+r][j+c]);
                            }
                        }
                    }
                    if(i==j) curr[i][j]=grid[row][i]+result;
                    else curr[i][j]=grid[row][i]+grid[row][j]+result;
                }
            }
            int[][] temp=curr;
            curr=dp;
            dp=temp;
        }
        return dp[0][cols-1];
    }
}