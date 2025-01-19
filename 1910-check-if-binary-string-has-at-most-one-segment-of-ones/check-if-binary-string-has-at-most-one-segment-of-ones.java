class Solution {
    public boolean checkOnesSegment(String s) {
        if(s.length()==1){
            return true;
        }
        int i=0;
        while(i<s.length()-1){
            if(s.charAt(i)=='0' && s.charAt(i+1)=='1'){
                return false;
            }
            else{
                i++;
            }
        }
        return true;
    }
}