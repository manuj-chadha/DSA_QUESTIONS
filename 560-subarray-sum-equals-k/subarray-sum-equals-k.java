class Solution {
    public int subarraySum(int[] nums, int k) {
        int total=0;
        int sum=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(0, 1);
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            if(map.containsKey(sum-k)){
                int val=map.get(sum-k);
                total+=val;
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return total;
    }
}