class Solution {
    boolean[][] visited;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        visited=new boolean[image.length][image[0].length];
        fillColor(image, sr, sc, color);
        return image;
    }
    private void fillColor(int[][] arr, int sr, int sc, int color) {
        visited[sr][sc]=true;

        int[] dx={0, -1, 0, 1};
        int[] dy={-1, 0, 1, 0};
        for(int a=0;a<4;a++) {
            int newX=sr+dx[a];
            int newY=sc+dy[a];
            if(newX>=0 && newX<arr.length && newY>=0 && newY<arr[0].length){
                if(!visited[newX][newY] && arr[newX][newY]==arr[sr][sc]){
                    fillColor(arr, newX, newY, color);
                }
            }
        }
        arr[sr][sc]=color;
    }
}