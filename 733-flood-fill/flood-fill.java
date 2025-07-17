class Solution {
    boolean[][] visited;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        visited=new boolean[m][n];
        dfs(image, sr, sc, color);
        return image;
    }
    private void dfs(int[][] image, int i, int j, int color){
        visited[i][j] = true;
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        
        for (int dir = 0; dir < 4; dir++) {
            int newRow = i + dx[dir];
            int newCol = j + dy[dir];
            
            if (newRow >= 0 && newRow < image.length && 
                newCol >= 0 && newCol < image[0].length && 
                !visited[newRow][newCol] && image[newRow][newCol] == image[i][j]) {
                dfs(image, newRow, newCol, color);
            }
        }
        image[i][j]=color;
    }

}