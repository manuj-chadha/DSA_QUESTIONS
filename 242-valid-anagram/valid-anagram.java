class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;

        int[] charS=new int[26];
        int[] charT=new int[26];

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            charS[s.charAt(i)-'a']++;
            charT[t.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(charS[i]!=charT[i]) return false;
        }
        return true;
    }
}