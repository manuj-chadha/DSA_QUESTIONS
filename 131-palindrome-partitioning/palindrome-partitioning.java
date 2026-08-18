class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans=new ArrayList<>();
        palindromePartition(s, 0, new ArrayList<>());
        return ans;
    }
    private void palindromePartition(String s, int start, List<String> partition) {
        if(start == s.length()){
            ans.add(new ArrayList<>(partition));
            return;
        }
        for(int i=start;i<s.length();i++) {
            if(validPalindrome(s, start, i)){
                partition.add(s.substring(start, i+1));
                palindromePartition(s, i+1, partition);
                partition.remove(partition.size()-1);
            }
        }
    }
    private boolean validPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}