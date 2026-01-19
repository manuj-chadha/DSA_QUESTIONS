class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp=new int[nums.length];
        Arrays.fill(dp, -1);
        return rob(nums, nums.length-1);
    }
    private int rob(int[] nums, int index){
        if(index<0) return 0;
        if(dp[index]!=-1) return dp[index];
        int rob=nums[index]+rob(nums, index-2);
        int notRob=rob(nums, index-1);
        return dp[index]=Math.max(rob, notRob);
    }
}