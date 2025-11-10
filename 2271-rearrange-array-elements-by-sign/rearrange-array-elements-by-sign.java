class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length/2;
        int[] positive=new int[n];
        int[] negative=new int[n];
        int i=0;
        int j=0;
        for(int num: nums){
            if(num>0) positive[i++]=num;
            else negative[j++]=num; 
        }
        int idx=0;
        for(int ind=0;ind<n*2;ind+=2){
            nums[ind]=positive[idx];
            nums[ind+1]=negative[idx];
            idx++;
        }
        return nums;
    }
}