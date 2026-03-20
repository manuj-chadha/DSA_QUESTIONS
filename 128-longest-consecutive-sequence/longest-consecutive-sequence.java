class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        HashSet<Integer> set=new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        int longest=1;
        for(int num: set){
            int curr=1;
            int ele=num;
            if(set.contains(num+1)) continue;
            while(set.contains(--ele)){
                curr++;
            }
            longest=Math.max(longest, curr);
        }
        return longest;
    }
}