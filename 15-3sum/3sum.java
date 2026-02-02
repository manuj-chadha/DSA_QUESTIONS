class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int i=0;
        Arrays.sort(nums);
        List<List<Integer>> triplets=new ArrayList<>();
        while(i<nums.length-2) {
            int val=nums[i];
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum=nums[j]+nums[k];
                if(sum==(-val)){
                    triplets.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    j++;
                    while(j<nums.length && nums[j]==nums[j-1]) j++;
                    k--;
                    while(k>=0 && nums[k]==nums[k+1]) k--;
                }
                else if(sum>(-val)) k--;
                else j++;
            }
            i++;
            while(i<nums.length && nums[i]==nums[i-1]) i++;
        }
        return triplets;
    }
}
