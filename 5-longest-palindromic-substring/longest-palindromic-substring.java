class Solution {
    public String longestPalindrome(String s) {
        int maxLen=1;
        String str=s.substring(0, 1);
        for(int i=1;i<s.length();i++){
            String s1=substringLength(s, i, i);
            String s2="";
            if(s.charAt(i-1)==s.charAt(i)) s2=substringLength(s, i-1, i);
            if(s1.length()>maxLen) {
                str=s1;
                maxLen=s1.length();
            }
            if(s2.length()>maxLen) {
                str=s2;
                maxLen=s2.length();
            }
        }
        return str;
    }
    private String substringLength(String s, int i, int j){
        while(i>=0 && j<s.length()){
            if(s.charAt(i)==s.charAt(j)){
                i--;
                j++;
            } else break;
        }
        return s.substring(i+1, j);
    }
}