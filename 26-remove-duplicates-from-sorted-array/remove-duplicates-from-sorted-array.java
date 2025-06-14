class Solution {
    public int removeDuplicates(int[] nums) {
        int len=nums.length;
        if(len==1) return 1;
        int i=0;
        int curr=1;
        while(curr<len){
            if(nums[i]==nums[curr]){
                curr++;
            }
            else{
                i++;
                nums[i]=nums[curr];
                curr++;
            }
        }
        return i+1;

    }
}