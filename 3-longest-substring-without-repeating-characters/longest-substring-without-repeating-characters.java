class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map=new HashMap<>();
        int l=0;
        int r=0;
        int max=0;
        while(r<s.length()){
            char ch=s.charAt(r);
            if(map.containsKey(ch) && map.get(ch)>=l){
                l=map.get(ch)+1;
            }
            map.put(ch, r);
            max=Math.max(max, r-l+1);
            r++;
        }
        return max;
    }
}