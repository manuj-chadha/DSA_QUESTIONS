class Solution {
    public long countSubarrays(int[] nums, long k) {
        int start=0;
        int end=0;
        long count=0;
        long sum=0;
        while(end<nums.length){
            int len=end-start+1;
            sum+=nums[end];
            long product=sum*len;
            while(product>=k && start<=end){
                product/=len;
                len--;
                product-=nums[start];
                product*=len;
                sum-=nums[start];
                start++;
            }
            count+=len;
            end++;
        }
        return count;
    }
}