class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        int[] need = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int required = t.length();
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (need[c] > 0) required--;
            need[c]--;
            right++;

            while (required == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char lc = s.charAt(left);
                need[lc]++;
                if (need[lc] > 0) required++;
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE 
            ? "" 
            : s.substring(start, start + minLen);
    }
}
