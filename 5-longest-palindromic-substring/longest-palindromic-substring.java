class Solution {
    public String longestPalindrome(String s) {
        int maxLen=1;
        String str=s.substring(0, 1);
        for(int i=0;i<s.length()-1;i++){
            String s1=substringLength(s, i, i);
            String s2=substringLength(s, i, i+1);
            System.out.println(s1 + " " + s2);
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