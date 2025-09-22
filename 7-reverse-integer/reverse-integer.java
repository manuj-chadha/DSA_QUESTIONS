class Solution {
    public int reverse(int x) {
        int sign= (x<0) ? -1 : 1;
        String num=String.valueOf(Math.abs(x));
        char[] ch=num.toCharArray();
        int start=0;
        int end=num.length()-1;
        while(start<end){
            char temp=ch[start];
            ch[start]=ch[end];
            ch[end]=temp;
            start++;
            end--;
        }
        String s=new String(ch);
        int n;
        try {
            n = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 0;
        }
        return n*sign;

    }
}