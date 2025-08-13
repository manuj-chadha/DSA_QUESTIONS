class Solution {
    public int minPathSum(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        int[] prev=new int[cols];
        for(int i=0;i<rows;i++){
            int[] curr=new int[cols];
            for(int j=0;j<cols;j++){
                if(i==0 && j==0) curr[j]=grid[0][0];
                else if(i==0) curr[j]=curr[j-1]+grid[i][j];
                else if(j==0) curr[j]=prev[j]+grid[i][j];
                else {
                    curr[j]=Math.min(prev[j], curr[j-1])+grid[i][j];
                }
            }
            prev=curr;
        }
        return prev[cols-1];
    }
}