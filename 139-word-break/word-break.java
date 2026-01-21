class Solution {
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp=new Boolean[s.length()];
        return findWordBreak(s, wordDict, 0);
    }
    private boolean findWordBreak(String s, List<String> wordDict, int i){
        if(i==s.length()) return true;
        if(dp[i]!=null) return dp[i];
        for(String word : wordDict){
            System.out.println(i);
            if(i+word.length()<=s.length() && 
            s.substring(i, i+word.length()).equals(word)){
                if(findWordBreak(s, wordDict, i+word.length())){
                    return dp[i]=true;
                }
            }
        }
        return dp[i]=false;
    }
}