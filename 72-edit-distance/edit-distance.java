class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        dp=new int[word1.length()][word2.length()];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return distance(word1, word2, 0, 0);
    }
    private int distance(String s1, String s2, int i, int j) {
        if(i==s1.length() && j==s2.length()) return 0;
        if(i==s1.length()){
            return s2.length()-j;
        }
        if(j==s2.length()){
            return s1.length()-i;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=distance(s1, s2, i+1, j+1);
        }
        return dp[i][j]=Math.min(distance(s1, s2, i+1, j+1), Math.min(distance(s1, s2, i, j+1), distance(s1, s2, i+1, j)))+1;
    }
}