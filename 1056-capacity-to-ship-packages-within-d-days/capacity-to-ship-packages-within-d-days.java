class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int right=0;
        int left=0;
        for(int weight: weights) {
            right+=weight;
            left=Math.max(left, weight);
        }
        while(left<=right){
            int mid=left+(right-left)/2;
            if(possible(weights, mid, days)){
                right=mid-1;
            }
            else left=mid+1;
        }
        return left;
    }
    private boolean possible(int[] nums, int val, int days) {
        int countedDays=1;
        int currWeight=0;
        for(int num: nums) {
            if(currWeight+num>val){
                countedDays++;
                currWeight=num;
            }
            else currWeight+=num;
        }
        return countedDays<=days;
    }
}