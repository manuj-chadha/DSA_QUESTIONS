class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min=1;
        int max=Integer.MIN_VALUE;
        for(int num: piles){
            max=Math.max(max, num);
        }
        while(min<=max) {
            int mid=min+(max-min)/2;

            if(possible(piles, mid, h)){
                max=mid-1;
            }
            else {
                min=mid+1;
            }
        }
        return min;
    }
    private boolean possible(int[] nums, int mid, int h) {
        long hours=0;
        for(int num: nums) {
            hours+=(num+mid-1)/mid;
            if(hours>h) return false;
        }
        return hours<=h;
    }
}