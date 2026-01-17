class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int max = 0;
        for (int i = 0; i < 26; i++) {
            char ch=(char) (65+i);
            int diff=0;
            int left = 0;
            int right = 0;
            while (right < s.length()) {
                if(s.charAt(right)!=ch) diff++;
                while(diff>k){
                    if(s.charAt(left)!=ch) diff--;
                    left++;
                }
                max=Math.max(max, right-left+1);

                right++;
            }
        }
        return max;
    }
}