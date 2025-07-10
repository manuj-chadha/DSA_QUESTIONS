class Solution {
    public int characterReplacement(String s, int k) {
        int maxWindow=0;
        int start=0;
        int end=0;
        int maxCount=0;
        int[] arr=new int[26];
        while(end<s.length()){
            int ch=s.charAt(end)-65;
            arr[ch]++;
            maxCount=Math.max(arr[ch], maxCount);
            if((end-start+1)-maxCount > k){
                arr[s.charAt(start)-'A']--;
                start++;
            }
            maxWindow=Math.max(maxWindow, end-start+1);
            end++;
        }
        return maxWindow;
    }
}