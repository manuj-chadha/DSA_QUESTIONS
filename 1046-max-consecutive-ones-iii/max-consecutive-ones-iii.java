class Solution {
    public int longestOnes(int[] nums, int k) { 
        int zeroes=0;
        int left=0;
        int right=0;
        int max=0;
        while(right<nums.length){
            while(zeroes>k && left<right){
                if(nums[left]==0) zeroes--;
                left++;
            }
            if(nums[right]==1) max=Math.max(max, right-left+1);
            else{
                if(zeroes<k){
                    max=Math.max(max, right-left+1);
                }
                zeroes++;
            }
            right++;
        }
        return max;
    }
}