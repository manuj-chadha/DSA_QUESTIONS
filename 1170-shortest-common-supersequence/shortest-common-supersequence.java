class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int len1=str1.length();
        int len2=str2.length();
        int[][] dp=new int[len1+1][len2+1];

        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)) dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(len1>0 && len2>0){
            if(str1.charAt(len1-1)==str2.charAt(len2-1)){
                sb.append(str1.charAt(len1-1));
                len1--;
                len2--;
            }
            else {
                if(dp[len1-1][len2]>dp[len1][len2-1]){
                    sb.append(str1.charAt(len1-1));
                    len1--;
                }
                else {
                    sb.append(str2.charAt(len2-1));
                    len2--;
                }
            }
        }
        while(len1>0){
            sb.append(str1.charAt(len1-1));
            len1--;
        }
        while(len2>0){
            sb.append(str2.charAt(len2-1));
            len2--;
        }
        return sb.reverse().toString();
    }
}