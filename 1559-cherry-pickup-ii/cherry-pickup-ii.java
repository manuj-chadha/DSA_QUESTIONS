class Solution {
    int[][][] dp;
    public int cherryPickup(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;
        dp=new int[rows][cols][cols];
        for(int[][] i: dp){
            for(int[] j: i){
                Arrays.fill(j, -1);
            }
        }
        return cherryPickup(grid, 0, 0, cols-1);
    }
    private int cherryPickup(int[][] grid, int r, int c1, int c2){
        if(c1<0 || c1>=grid[0].length || c2<0 || c2>=grid[0].length){
            return (int)-1e8;
        }
        if(r==grid.length-1){
            if(c1==c2) return grid[r][c1];
            else return grid[r][c1]+grid[r][c2];
        } 
        if(dp[r][c1][c2]!=-1) return dp[r][c1][c2];

        int result=Integer.MIN_VALUE;
        for(int i=-1;i<2;i++){
            for(int j=-1;j<2;j++){
                result=Math.max(result, cherryPickup(grid, r+1, c1+i, c2+j));
            }
        }
        if(c1==c2) return dp[r][c1][c2]=grid[r][c1]+result;
        return dp[r][c1][c2]=grid[r][c1]+grid[r][c2]+result;
    }
}