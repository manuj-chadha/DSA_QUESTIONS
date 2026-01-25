class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        StringBuilder str=new StringBuilder(s);
        reverse(str, 0, str.length());
        int i=0;
        int j=0;
        while(j<str.length()){
            while(j<str.length() && str.charAt(j)!=' ') j++;
            reverse(str, i, j++);
            while(j<str.length() && str.charAt(j)==' ') str.deleteCharAt(j);
            i=j;
        }
        return str.toString();
    }
    private void reverse(StringBuilder str, int a, int b){
        int i=a;
        int j=b-1;
        while(i<j){
            char temp=str.charAt(i);
            str.setCharAt(i, str.charAt(j));
            str.setCharAt(j, temp);
            i++;
            j--;
        }
    }
}