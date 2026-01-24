class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0;
        int ten=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                five++;
            }
            else if(bills[i]==10){
                if(five>0){
                    five-=1;
                    ten++;
                }
                else {
                    return false;
                }
            }
            else {
                int change=15;
                if(ten>0){
                    ten--;
                    change-=10;
                }
                while(change>0){
                    if(five==0) return false;
                    change-=5;
                    five--;
                }
            }
        }
        return true;
    }
}