class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1) return -1;
        int[] dx={-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy={-1, 0, 1, -1, 1, -1, 0, 1};
        Queue<int[]> queue=new LinkedList<>();
        int shortest=1;
        queue.add(new int[]{0, 0});
        grid[0][0]=1;
        while(!queue.isEmpty()) {
            int n=queue.size();
            for(int a=0;a<n;a++){
                int[] node=queue.poll();
                if(node[0]==grid.length-1 && node[1]==grid[0].length-1) return shortest;
                for(int i=0;i<8;i++){
                    int newX=node[0]+dx[i];
                    int newY=node[1]+dy[i];
                    if(newX>=0 && newX<grid.length && newY>=0 && newY<grid[0].length){
                        if(grid[newX][newY]==0){
                            queue.add(new int[]{newX, newY});
                            grid[newX][newY]=1;
                        }
                    }
                }
            }
            if(queue.isEmpty()) return -1;
            shortest++;
        }
        return shortest;
    }
}