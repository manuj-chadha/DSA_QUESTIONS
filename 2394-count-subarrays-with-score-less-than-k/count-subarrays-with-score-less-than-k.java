class Solution {
    public long countSubarrays(int[] nums, long k) {
        int start=0;
        int end=0;
        long sum=0;
        long total=0;
        while(end<nums.length){
            sum+=nums[end];
            while(sum*(end-start+1)>=k){
                sum-=nums[start];
                start++;
            }
            total+=(end-start+1);
            end++;
        }
        return total;
    }
}