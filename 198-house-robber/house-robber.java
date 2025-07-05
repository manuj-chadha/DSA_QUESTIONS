class Solution {
    public int rob(int[] nums) {
        int len=nums.length;
        if(len==1) return nums[0];
        int prev=nums[len-1];
        int curr=Math.max(nums[len-2], nums[len-1]);
        int next=0;
        for(int index=len-3;index>=0;index--){
            next=Math.max(prev + nums[index], curr);
            prev=curr;
            curr=next;
        }
        return curr;
    }
}