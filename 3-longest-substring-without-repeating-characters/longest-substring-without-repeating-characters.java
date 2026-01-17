class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int right=0;
        int[] map=new int[255];
        Arrays.fill(map, -1);
        int max=0;
        while(right<s.length()){
            int ch=(int) s.charAt(right);
            if(map[ch]!=-1 && map[ch]>=left){
                left=map[ch]+1;
            }
            map[ch]=right;
            max=Math.max(max, right-left+1);
            right++;
        }
        return max;
    }
}