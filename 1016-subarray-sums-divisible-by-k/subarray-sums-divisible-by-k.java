class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int total=0;
        int sum=0;
        HashMap<Integer, Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int modulo=sum%k;
            if(modulo<0) modulo+=k;
            total+=map.getOrDefault(modulo, 0);
            map.put(modulo, map.getOrDefault(modulo, 0)+1);
        }
        return total;
    }
}