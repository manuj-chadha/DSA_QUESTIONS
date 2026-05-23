class Solution {
    public int majorityElement(int[] nums) {
        int element=nums[0];
        int occurance=0;
        for(int num: nums){
            if(occurance==0){
                element=num;
            }
            if(num==element) occurance++;
            else occurance--;
        }
        return element;
    }
}