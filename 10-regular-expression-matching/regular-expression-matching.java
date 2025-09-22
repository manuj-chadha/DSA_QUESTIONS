class Solution {
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        int sin=s.length()-1;
        int pin=p.length()-1;
        dp=new Boolean[sin+1][pin+1];
        return regex(s, p, sin, pin);
    }
    private boolean regex(String s, String p, int sin, int pin){
        if(sin<0 && pin<0) return true;
        if(sin>=0 && pin<0) return false;
        if (sin < 0) {
            while (pin >= 0) {
                if (p.charAt(pin) == '*') {
                    pin -= 2;
                } else {
                    return false;
                }
            }
            return true;
        }

        if(dp[sin][pin]!=null) return dp[sin][pin];
        if(s.charAt(sin)==p.charAt(pin) || p.charAt(pin)=='.'){
            return dp[sin][pin]=regex(s, p, sin-1, pin-1);
        }
        if(p.charAt(pin)=='*'){
            boolean zero=regex(s, p, sin, pin-2);
            boolean one=(sin>=0 && (s.charAt(sin)==p.charAt(pin-1) || p.charAt(pin-1)=='.')) && regex(s, p, sin-1, pin);
            return dp[sin][pin]=zero || one;
        }
        return dp[sin][pin]=false;
    }
}