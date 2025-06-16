class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> ans=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            HashSet<Integer> map=new HashSet<>();
            for(int j=i+1;j<nums.length;j++){
                int k=-(nums[i]+nums[j]);
                if(map.contains(k)){
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j], k));
                    Collections.sort(list);
                    if(!ans.contains(list)) ans.add(list);
                }
                map.add(nums[j]);
            }
        }
        return new ArrayList<>(ans);
    }
}