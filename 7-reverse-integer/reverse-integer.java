class Solution {
    public int reverse(int x) {
        int num=Math.abs(x);
        int rev=0;
        try{
            while(num>0){
                int d=num%10;
                if (rev > Integer.MAX_VALUE/10 || 
                (rev == Integer.MAX_VALUE/10 && d > 7)) return 0;
                if (rev < Integer.MIN_VALUE/10 || 
                (rev == Integer.MIN_VALUE/10 && d > 8)) return 0;

                rev=rev*10+d;
                num/=10;
            }
        } catch(NumberFormatException e){
            return 0;
        } 

        if(x<0) return rev*(-1);
        return rev;
    }
}