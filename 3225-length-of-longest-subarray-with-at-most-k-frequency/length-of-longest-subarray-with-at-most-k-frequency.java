class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int start=0;
        int end=0;
        int len=Integer.MIN_VALUE;
        HashMap<Integer, Integer> map=new HashMap<>();
        while(end<nums.length && start<=end){
            int val=nums[end];
            map.put(val, map.getOrDefault(val, 0)+1);
            while(map.get(val)>k){
                map.put(nums[start], map.get(nums[start])-1);
                start++;
            }
            len=Math.max(len, end-start+1);
            end++;
        }
        return len;
    }
}