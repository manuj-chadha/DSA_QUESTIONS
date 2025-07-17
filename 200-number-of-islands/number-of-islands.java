class Solution {
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        visited=new boolean[m][n];
        int islands=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;

    }
    private void dfs(char[][] grid, int i, int j){
    visited[i][j] = true;

    int[] dx = {-1, 0, 0, 1};
    int[] dy = {0, -1, 1, 0};
    
    for (int dir = 0; dir < 4; dir++) {
        int newRow = i + dx[dir];
        int newCol = j + dy[dir];
        
        if (newRow >= 0 && newRow < grid.length && 
            newCol >= 0 && newCol < grid[0].length && 
            !visited[newRow][newCol] && grid[newRow][newCol] == '1') {
            dfs(grid, newRow, newCol);
        }
    }
}


}