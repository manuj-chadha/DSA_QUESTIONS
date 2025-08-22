class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] prev=new int[n];
        prev[0]=grid[0][0];
        for(int i=1;i<n;i++){
            prev[i]=grid[0][i]+prev[i-1];
        }
        for(int i=1;i<m;i++){
            int[] curr=new int[n];
            for(int j=0;j<n;j++){
                if(j==0) curr[j]=prev[j]+grid[i][j];
                else curr[j]=Math.min(prev[j], curr[j-1])+grid[i][j];
            }
            prev=curr;
        }
        return prev[n-1];
    }
}