class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int prev=nums[0];   
        int curr=Math.max(nums[0], nums[1]);
        for(int i=2;i<nums.length;i++){
            int max=Math.max(prev+nums[i], curr);
            prev=curr;
            curr=max;
        }
        return curr;
    }
}