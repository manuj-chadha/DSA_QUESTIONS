class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int value=target-nums[i];
            if(map.containsKey(value)) return new int[]{map.get(value), i};
            else map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}