class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        
        int n=words.length;
        int[] dp=new int[n];
        int[] hash=new int[n];
        Arrays.fill(dp, 1);
        int maxi=1;
        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(isPredecessor(words[prev], words[i])){
                    dp[i]=Math.max(dp[i], dp[prev]+1);
                }
            }
            maxi=Math.max(maxi, dp[i]);
        }
        return maxi;
    }
    private boolean isPredecessor(String a, String b){
        if(b.length()!=a.length()+1) return false;
        int mismatch=0;
        int i=0;
        int j=0;
        while(i<a.length() && j<b.length()){
            if(a.charAt(i)==b.charAt(j)){
                i++;
                j++;
            }
            else {
                if(mismatch>=1) return false;
                mismatch++;
                j++;
            }
        }
        return true;
    }
}