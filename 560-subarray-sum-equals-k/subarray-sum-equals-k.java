class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(0, 1);
        int currSum=0;
        int subarrays=0;
        for(int num: nums) {
            currSum+=num;
            if(map.containsKey(currSum-k)) {
                subarrays+=map.get(currSum-k);
            }
            map.put(currSum, map.getOrDefault(currSum, 0)+1);
        }
        return subarrays;
    }
}