class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0], nums[1]);
        return Math.max(houseRobber(nums, 0, nums.length-1), houseRobber(nums, 1, nums.length));
    }
    private int houseRobber(int[] nums, int s, int e) {
        int prev=nums[s];
        int curr=Math.max(nums[s], nums[s+1]);
        for(int i=s+2;i<e;i++){
            int max=Math.max(prev+nums[i], curr);
            prev=curr;
            curr=max;
        }
        return curr;
    }
}