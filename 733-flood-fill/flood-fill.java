class Solution {
    int oldColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color==image[sr][sc]) return image;
        oldColor=image[sr][sc];
        fillColor(image, sr, sc, color);
        return image;
    }
    private void fillColor(int[][] arr, int sr, int sc, int color) {
        arr[sr][sc]=color;
        int[] dx={0, -1, 0, 1};
        int[] dy={-1, 0, 1, 0};
        for(int a=0;a<4;a++) {
            int newX=sr+dx[a];
            int newY=sc+dy[a];
            if(newX>=0 && newX<arr.length && newY>=0 && newY<arr[0].length){
                if(arr[newX][newY]!=color && arr[newX][newY]==oldColor){
                    fillColor(arr, newX, newY, color);
                }
            }
        }
    }
}