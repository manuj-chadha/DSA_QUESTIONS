class Solution {
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        visited=new boolean[grid.length][grid[0].length];
        int islands=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    islands(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }
    private void islands(char[][] grid, int i, int j) {
        visited[i][j]=true;
        int[] x={0, 1, -1, 0};
        int[] y={-1, 0, 0, 1};
        for(int a=0;a<4;a++){
            int newX=i+x[a];
            int newY=j+y[a];
            if(newX>=0 && newX<grid.length && newY>=0 && newY<grid[0].length){
                if(!visited[newX][newY] && grid[newX][newY]=='1') islands(grid, newX, newY);
            }
        }
    }
}
