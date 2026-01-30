class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes=0;
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==2) queue.add(new int[]{i, j});
            }
        }
        int[] dx={1, -1, 0, 0};
        int[] dy={0, 0, 1, -1};
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] orange=queue.poll();
                for(int a=0;a<4;a++) {
                    int newX=orange[0]+dx[a];
                    int newY=orange[1]+dy[a];
                    if(newX>=0 && newX<grid.length && newY>=0 && newY<grid[0].length){
                        if(grid[newX][newY]==1){
                            grid[newX][newY]=2;
                            queue.add(new int[]{newX, newY});
                        }
                    }
                }
            }
            if(!queue.isEmpty()) minutes++;
        }
        for(int[] arr: grid){
            for(int val: arr){
                if(val==1) return -1;
            }
        }
        return minutes;
    }
}