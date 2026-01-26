class Solution {
    public int trailingZeroes(int n) {
        int five=0;
        int num=5;
        while(n/num>0){
            five+=n/num;
            num=num*5;
        }
        return five;
    }
}