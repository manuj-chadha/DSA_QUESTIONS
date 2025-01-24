class Solution {
    public void sortColors(int[] nums) {
        int zero=0;
        int ones=0;
        int twos=0;
        int len=nums.length;
        for(int i=0;i<len;i++){
            if(nums[i]==0){
                zero++;
            }
            else if(nums[i]==1){
                ones++;
            }
            else {
                twos++;
            }
        }
        int index=0;
        while(zero>0){
            nums[index++]=0;
            zero--;
        }
        while(ones>0){
            nums[index++]=1;
            ones--;
        }
        while(twos>0){
            nums[index++]=2;
            twos--;
        }
    }
}