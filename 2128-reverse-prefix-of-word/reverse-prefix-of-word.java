class Solution {
     public String reversePrefix(String word, char ch) {
        StringBuffer sb=new StringBuffer(word);
        int index=0;
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)==ch){
                index=i;
                break;
            }
        }
        
        if(index==0){
            return word;
        }
        int start=0;
        while(start<index){
            swap(start, index, sb);
            start++;
            index--;
        }
        return sb.toString();

    }

    private void swap(int start, int index, StringBuffer sb) {
        Character temp=sb.charAt(start);
        sb.setCharAt(start, sb.charAt(index));
        sb.setCharAt(index,temp);
    }
}