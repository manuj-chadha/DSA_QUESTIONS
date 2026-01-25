class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1) return strs[0];
        String word=strs[0];
        int prefix=200;
        for(int i=1;i<strs.length;i++) {
            prefix=Math.min(prefix, findLongestPrefix(word, strs[i]));
            if(prefix==0) return "";
        }
        return strs[0].substring(0, prefix);
    }
    private int findLongestPrefix(String s1, String s2) {
        if(s1.length()==0 || s2.length()==0) return 0;
        int lesser=Math.min(s1.length(), s2.length());
        int count=0;
        for(int i=0;i<lesser;i++){
            if(s1.charAt(i)==s2.charAt(i)) count++;
            else return count;
        }
        return count;
    }
}