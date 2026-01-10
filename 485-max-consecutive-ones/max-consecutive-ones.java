class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int longestStreak=0;
        int streak=0;
        for(int i: nums){
            if(i==1) streak++;
            else {
                longestStreak=Math.max(streak, longestStreak);
                streak=0;
            }
        }
        return Math.max(streak, longestStreak);
    }
}