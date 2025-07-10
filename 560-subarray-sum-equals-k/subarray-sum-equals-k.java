class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(0, 1);
        int prefixSum=0;
        int total=0;
        for(int val: nums){
            prefixSum+=val;
            if(map.containsKey(prefixSum-k)){
                total+=map.get(prefixSum-k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return total;
    }
}