class Solution {
    public int climbStairs(int n) {
        if(n<=1) return 1;
        int prev=1;
        int curr=1;
        int next=0;
        for(int i=2;i<n+1;i++){
            next=prev+curr;
            prev=curr;
            curr=next;
        }
        return next;
    }
}