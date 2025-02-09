class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start=0;
        int end=0;
        int sum=0;
        int size=Integer.MAX_VALUE;
        while(end<nums.length){
            sum+=nums[end];
            while(sum>=target){
                sum-=nums[start];
                size=Math.min(size, (end-start)+1);
                start++;
            }
            end++;
        }
        return size==Integer.MAX_VALUE ? 0: size;
    }
}