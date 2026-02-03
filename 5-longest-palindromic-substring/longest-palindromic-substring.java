class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==1) return s;
        String str="";
        int max=0;
        for(int i=1;i<s.length();i++){
            String a=longest(s, i, i);
            String b="";
            if(s.charAt(i-1)==s.charAt(i)){
                b=longest(s, i-1, i);
            }
            if(a.length()>max){
                max=a.length();
                str=a;
            }
            if(b.length()>max){
                max=b.length();
                str=b;
            }
        }
        return str;
    }
    private String longest(String s, int start, int end){
        while(start>=0 && end<s.length()){
            if(s.charAt(start)==s.charAt(end)){
                start--;
                end++;
            }
            else break;
        }
        return s.substring(start+1, end);

    }
}