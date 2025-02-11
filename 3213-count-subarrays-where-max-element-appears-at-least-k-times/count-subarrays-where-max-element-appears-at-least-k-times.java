class Solution {
    public long countSubarrays(int[] nums, int k) {
        int start=0;
        int end=0;
        long total=0;
        int i=0;
        int arr_len=nums.length;
        int max=Integer.MIN_VALUE;
        while(i<arr_len){
            max=Math.max(max, nums[i]);
            i++;
        }
        int occ=0;
        while(end<arr_len){
            int val=nums[end];
            if(val==max) occ++;
            while(occ>=k){
                total+=arr_len-end;
                if(nums[start]==max) occ--;
                start++;
            }
            end++;
        }
        return total;
    }
}