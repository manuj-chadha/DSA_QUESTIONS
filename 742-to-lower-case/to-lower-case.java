class Solution {
    public String toLowerCase(String s) {
        int[] ch=new int[s.length()];
        for(int i=0;i<ch.length;i++){
            int val=(int) s.charAt(i);
            if(val>=65 && val<=90){
                ch[i]=val+32;
            }
            else{
                ch[i]=val;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ch.length;i++){
            sb.append((char) ch[i]);
        }
        return sb.toString();
    }
}