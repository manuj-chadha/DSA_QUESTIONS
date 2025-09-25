class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        int longestStreak=0;
        for(int num: set){
            if(!set.contains(num-1)){
                int currentNum=num;
                int currentStreak=1;
                while(set.contains(currentNum+1)){
                    currentStreak++;
                    currentNum++;
                }
                longestStreak=Math.max(currentStreak, longestStreak);
            }
        }
        return longestStreak;
    }
}