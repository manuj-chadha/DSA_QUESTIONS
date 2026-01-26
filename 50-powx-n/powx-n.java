class Solution {
    public double myPow(double x, int n) {
        long num=n;
        if(n<0){
            x=1/x;
            num=-num;
        }
        double result=1;
        while(num>0) {
            if((num & 1)==1) {
                result=result*x;
            }
            x=x*x;
            num=num/2;
        }
        return result;
    }
}