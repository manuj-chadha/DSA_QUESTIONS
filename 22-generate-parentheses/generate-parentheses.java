class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans=new ArrayList<>();
        generateParenthesis(0, 0, "", n);
        return ans;
    }
    private void generateParenthesis(int openUsed, int closeUsed, String str, int n) {
        if(str.length()==n*2) {
            ans.add(str);
            return;
        }
        if(openUsed<n){
            generateParenthesis(openUsed+1, closeUsed, str.concat("("), n);
        }
        if(closeUsed<openUsed){
            generateParenthesis(openUsed, closeUsed+1, str.concat(")"), n);
        }
    }
}