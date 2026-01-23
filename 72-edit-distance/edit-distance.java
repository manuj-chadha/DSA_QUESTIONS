class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        dp=new int[word1.length()+1][word2.length()+1];
        for(int[] arr: dp) Arrays.fill(arr, -1);
        return findMinimum(word1, word2, 0, 0);
    }
    private int findMinimum(String s1, String s2, int i, int j) {
        if(i==s1.length() && j==s2.length()) return 0;
        else if(i==s1.length()){
            return dp[i][j]=s2.length()-j;
        }
        else if(j==s2.length()) {
            return dp[i][j]=s1.length()-i;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)){
            return dp[i][j]=findMinimum(s1, s2, i+1, j+1);
        }
        return dp[i][j]=Math.min(findMinimum(s1, s2, i+1, j+1), 
        Math.min(findMinimum(s1, s2, i+1, j), findMinimum(s1, s2, i, j+1)))+1;

    }
}