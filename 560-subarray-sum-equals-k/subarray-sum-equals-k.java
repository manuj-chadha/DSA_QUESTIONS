class Solution {
    public int subarraySum(int[] nums, int k) {
        int right=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(0, 1);
        int subarrays=0;
        int currSum=0;
        while(right<nums.length) {
            currSum+=nums[right];
            if(map.containsKey(currSum-k)){
                subarrays+=map.get(currSum-k);
            }
            map.put(currSum, map.getOrDefault(currSum, 0)+1);
            right++;
        }
        return subarrays;
    }
}