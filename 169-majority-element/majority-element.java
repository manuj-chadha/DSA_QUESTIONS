class Solution {
    public int majorityElement(int[] nums) {
        int val=nums[0];
        int occ=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==val) occ++;
            else{
                occ--;
                if(occ==0){
                    val=nums[i];
                    occ=1;
                }
            }
        }
        return val;
    }
}