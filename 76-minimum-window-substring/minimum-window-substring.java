class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";

        int left = 0;
        int right = 0;

        HashMap<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }

        HashMap<Character, Integer> curr = new HashMap<>();
        int required = need.size();
        int formed = 0;

        int min = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            curr.put(ch, curr.getOrDefault(ch, 0) + 1);

            if (need.containsKey(ch) && need.get(ch).equals(curr.get(ch))) {
                formed++;
            }

            while (formed == required) {
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    start = left;
                }

                char chLeft = s.charAt(left);
                curr.put(chLeft, curr.get(chLeft) - 1);

                if (need.containsKey(chLeft) && curr.get(chLeft) < need.get(chLeft)) {
                    formed--;
                }

                left++;
            }
            right++;
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}
