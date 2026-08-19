class Solution {
    List<String> ans;
    public List<String> restoreIpAddresses(String s) {
        ans=new ArrayList<>();
        restoreIP(s, 0, new ArrayList<>());
        return ans;
    }
    private void restoreIP(String s, int start, List<String> segments) {
        if(segments.size() == 4) {
            if(start == s.length()) {
                String ip=String.join(".", segments);
                ans.add(ip);
                return;
            }
        }
        for(int i=start;i<s.length();i++){
            String str=s.substring(start, i+1);
            if(isValid(str)){
                segments.add(str);
                restoreIP(s, i+1, segments);
                segments.remove(segments.size()-1);
            }
        }
    }
    private boolean isValid(String str){
        if((str.length()>1 && str.startsWith("0")) || str.length()>3) return false;
        int segment=Integer.parseInt(str);
        if(segment>255) return false;
        return true;
    }
}