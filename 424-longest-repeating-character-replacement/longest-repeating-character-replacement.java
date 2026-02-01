class Solution {
    public int characterReplacement(String s, int k) {
        int left=0;
        int right=0;
        int[] hash=new int[26];
        int maxFreq=0;
        int longest=0;
        while(right<s.length()) {
            char ch=s.charAt(right);
            hash[ch-'A']++;
            maxFreq=Math.max(maxFreq, hash[ch-'A']);
            while(((right-left+1)-maxFreq)>k){
                hash[s.charAt(left)-'A']--;
                left++;
            }
            longest=Math.max(longest, right-left+1);
            right++;
        }
        return longest;
    }
}