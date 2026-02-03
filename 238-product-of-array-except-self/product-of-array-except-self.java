class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        ans[0]=1;
        for(int i=1;i<ans.length;i++){
            ans[i]=ans[i-1]*nums[i-1];
        }
        for(int i=n-2;i>=0;i--){
            nums[i]=nums[i]*nums[i+1];
        }
        for(int i=0;i<ans.length-1;i++){
            ans[i]*=nums[i+1];
        }
        return ans;

    }
}
