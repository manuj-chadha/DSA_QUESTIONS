class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int total=0;
        int sum=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(0, 1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int val=sum%k;
            if(val<0) val+=k;
            total+=map.getOrDefault(val, 0);
            map.put(val, map.getOrDefault(val,0)+1);
        }
        return total;
    }
}