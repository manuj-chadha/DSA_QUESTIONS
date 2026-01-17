class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int totalPoints=0;
        for(int card: cardPoints){
            totalPoints+=card;
        }
        int n=cardPoints.length;
        int sum=0;
        for(int i=0;i<n-k;i++){
            sum+=cardPoints[i];
        }
        int max=totalPoints-sum;
        int left=0;
        int right=n-k;
        while(right<cardPoints.length){
            sum-=cardPoints[left];
            sum+=cardPoints[right];
            max=Math.max(max, totalPoints-sum);
            left++;
            right++;
        }
        return max;
    }
}