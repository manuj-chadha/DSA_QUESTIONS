class Solution {
    Boolean[] dp;
    public boolean canJump(int[] nums) {
        dp=new Boolean[nums.length];
        dp[nums.length-1]=true;
        return canJump(nums, 0);   
    }
    private boolean canJump(int[] nums, int i) {
        if(i>=nums.length-1) return true;
        if(nums[i]==0) return false;
        if(dp[i]!=null) return dp[i];
        boolean possible=false;
        for(int a=1;a<=nums[i];a++){
            possible=possible || canJump(nums, i+a);
        }
        return dp[i]=possible;
    }
}