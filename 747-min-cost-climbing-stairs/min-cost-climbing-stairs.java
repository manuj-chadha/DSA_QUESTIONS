class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len=cost.length;
        int prev=cost[len-1];
        int curr=cost[len-2];
        int next=0;
        for(int index=cost.length-3;index>=0;index--){
            next=Math.min(prev, curr)+cost[index];
            prev=curr;
            curr=next;
        }
        return Math.min(curr, prev);
    }
}