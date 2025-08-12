class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        return Math.max(rob(nums, 0, n-2), rob(nums, 1, n-1));
    }
    private int rob(int[] nums, int start, int end){
        if (start == end) return nums[start];
        int iminus2=nums[start];
        int iminus1=Math.max(nums[start], nums[start+1]);
        for(int i=start+2;i<=end;i++){
            int left=iminus1;
            int right=nums[i]+iminus2;
            iminus2=iminus1;
            iminus1=Math.max(left, right);
        }
        return iminus1;
    }
}