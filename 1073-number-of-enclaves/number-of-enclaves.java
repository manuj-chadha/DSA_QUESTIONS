class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            if(grid[i][0]==1){
                dfs(grid, i, 0);
            } if(grid[i][n-1]==1){
                dfs(grid, i, n-1);
            }
        }
        for(int i=0;i<n;i++){
            if(grid[0][i]==1){
                dfs(grid, 0, i);
            }if(grid[m-1][i]==1){
                dfs(grid, m-1, i);
            }
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) count++;
            }
        }
        return count;
    }
    private void dfs(int[][] grid, int i, int j){
        grid[i][j]=2;
        int[] dx={-1, 0, 0, 1};
        int[] dy={0, -1, 1, 0};
        for(int a=0;a<4;a++){
            int nextR=i+dx[a];
            int nextC=j+dy[a];
            if(nextR>=0 && nextR<grid.length && nextC>=0 && nextC<grid[0].length && grid[nextR][nextC]==1){
                dfs(grid, nextR, nextC);
            }
        }
    }
}