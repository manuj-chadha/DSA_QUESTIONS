class Solution {
    int start=0;
    int end=0;
    int max=1;
    public String longestPalindrome(String s) {
        int n=s.length();
        for(int i=0;i<n;i++){
            expand(s, i, i);
            expand(s, i, i+1);
        }
        return s.substring(start, end+1);
    }
    private void expand(String s, int left, int right){
        if(left<0 || right>=s.length()) return;
        if(s.charAt(left)==s.charAt(right)){
            if(right-left+1>max){
                max=right-left+1;
                start=left;
                end=right;
            }
            expand(s, left-1, right+1);
        }
        return;
    }
}