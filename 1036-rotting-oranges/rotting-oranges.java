class Solution {
    public int orangesRotting(int[][] grid) {
        int time=0;
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2) queue.offer(new int[]{i, j});
            }
        }
        while(!queue.isEmpty()){
            int size=queue.size();
            boolean rotted=false;
            for(int k=0;k<size;k++){
                int[] arr=queue.poll();
                int[] dx={-1, 0, 0, 1};
                int[] dy={0, -1, 1, 0};
                for(int i=0;i<4;i++){
                    int nextR=arr[0]+dx[i];
                    int nextC=arr[1]+dy[i];
                    if(nextR>=0 && nextR<grid.length && nextC>=0 && nextC<grid[0].length && grid[nextR][nextC]==1){
                        grid[nextR][nextC]=2;
                        queue.offer(new int[]{nextR, nextC});
                        rotted=true;
                    }
                }
            }
            if(rotted) time++;
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) return -1;
            }
        }
        return time;
    }
}