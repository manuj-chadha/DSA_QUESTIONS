class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len=0;
        int streak=0;
        for(int i: nums){
            if(i==1) streak++;
            else {
                len=Math.max(len, streak);
                streak=0;
            }
        }
        return Math.max(streak, len);
    }
}