class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);
        return Math.max(robber(nums, 0, n-2), robber(nums, 1, n-1));
    }
    int robber(int[] nums, int start, int end){
        int len=end-start+1;
        int[] dp=new int[len];
        dp[len-1]=nums[end];
        if(len>1){
            dp[len-2]=Math.max(nums[end], nums[end-1]);
        }
        for(int i=len-3;i>=0;i--){
            dp[i]=Math.max(dp[i+1], dp[i+2]+nums[start+i]);
        }
        return dp[0];

    }

}