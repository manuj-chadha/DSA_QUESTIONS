class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int right=0;
        HashMap<Character, Integer> map=new HashMap<>();
        int max=0;
        while(right<s.length()){
            char ch=s.charAt(right);
            if(map.containsKey(ch) && map.get(ch)>=left){
                left=map.get(ch)+1;
            }
            map.put(ch, right);
            max=Math.max(max, right-left+1);
            right++;
        }
        return max;
    }
}