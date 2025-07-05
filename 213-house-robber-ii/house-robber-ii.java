class Solution {
    int[] dp1, dp2;
    int n=0;
    public int rob(int[] nums) {
        n=nums.length;
        if (n == 1) return nums[0];
        dp1=new int[n-1];
        dp2=new int[n-1];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        return Math.max(robfromZero(nums, n-1, 0), robfromOne(nums, n, 1));
    }
    public int robfromZero(int[] nums, int end, int index){
        if(index>=end) return 0;
        if(dp1[index]!=-1) return dp1[index];
        return dp1[index]=Math.max(robfromZero(nums, end, index+2)+nums[index], robfromZero(nums, end, index+1));
    }
    public int robfromOne(int[] nums, int end, int index){
        if(index>=end) return 0;
        if(dp2[index-1]!=-1) return dp2[index-1];
        return dp2[index-1]=Math.max(robfromOne(nums, end, index+2)+nums[index], robfromOne(nums, end, index+1));
    }
}