import java.util.Hashtable;
class Solution {
    public char findTheDifference(String s, String t) {
        char ch=t.charAt(0);
        for(int i=0;i<s.length();i++){
            ch^=s.charAt(i);
            ch^=t.charAt(i+1);
        }
        return ch;
    }
}