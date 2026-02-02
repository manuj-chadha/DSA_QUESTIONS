class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length<4) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> quads=new ArrayList<>();
        int i=0;
        while(i<nums.length-3) {
            int j=i+1;
            while(j<nums.length-2){
                long tar=(long) (target-((long) nums[i]+nums[j]));
                int k=j+1;
                int m=nums.length-1;
                while(k<m){
                    long sum=(long) nums[k]+nums[m];
                    if(sum==tar){
                        quads.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[m])));
                        k++;
                        while(k<nums.length && nums[k]==nums[k-1]) k++;
                        m--;
                        while(m>=0 && nums[m]==nums[m+1]) m--;
                    }
                    else if(sum<tar){
                        k++;
                    } 
                    else {
                        m--;
                    }
                }
                j++;
                while(j<nums.length && nums[j]==nums[j-1]) j++;
            }
            i++;
            while(i<nums.length && nums[i]==nums[i-1]) i++;
        }
        return quads;
    }
}