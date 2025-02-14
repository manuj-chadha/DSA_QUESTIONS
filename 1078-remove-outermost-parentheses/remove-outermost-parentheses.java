class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int depth = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (depth > 0) result.append(c); // Ignore outermost '('
                depth++;
            } else {
                depth--;
                if (depth > 0) result.append(c); // Ignore outermost ')'
            }
        }
        return result.toString();
    }
}
