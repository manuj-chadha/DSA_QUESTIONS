class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start=0;
        int end=0;
        int product=1;
        int total=0;
        while(end<nums.length){
            product*=nums[end];
            while(product>=k && start<=end){
                product/=nums[start];
                start++;
            }
            total+=(end-start+1);
            end++;
        }
        return total;
    }
}