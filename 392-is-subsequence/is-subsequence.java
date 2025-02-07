class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0) return true;
        if(t.length()==0) return false;
        char[] str=s.toCharArray();
        int index=0;
        
        for(int i=0;i<t.length();i++){
            if(index==str.length) return true;
            if(str[index]==(t.charAt(i))) index++;
        }
        if(index==str.length) return true;
        return false;
    }
}