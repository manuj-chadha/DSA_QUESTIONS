class Solution {
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        dp=new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int[] arr: dp) Arrays.fill(arr, -1);
        return findPaths(obstacleGrid, 0, 0);
    }
    private int findPaths(int[][] nums, int row, int col){
        if(row>=nums.length) return 0;
        if(col>=nums[0].length) return 0;
        if(nums[row][col]==1) return 0;
        if(row==nums.length-1 && col==nums[0].length-1) return 1;
        if(dp[row][col]!=-1) return dp[row][col];
        return dp[row][col]=findPaths(nums, row+1, col)+findPaths(nums, row, col+1);
    }
}