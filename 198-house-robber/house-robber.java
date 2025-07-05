class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp=new int[nums.length];
        Arrays.fill(dp, -1);
        return Math.max(money(nums, 0), money(nums, 1));
    }
    public int money(int[] nums, int index){
        if(index>=nums.length) return 0;
        if(dp[index]!=-1) return dp[index];
        return dp[index]=Math.max(money(nums, index+2) + nums[index], money(nums, index+1));
    }
}