class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb=new StringBuilder();
        int n=s.length()-1;
        while(n>=0){
            char ch=s.charAt(n);
            if(ch!='#'){
                char add=(char) ('a'+(ch-'0')-1);
                sb.append(add);
                n--;
            }
            else{
                int val=Integer.parseInt(s.substring(n-2, n));
                char add=(char) ('a'+val-1);
                sb.append(add);
                n-=3;
            }
        }
        return sb.reverse().toString();
    }
}