class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] wordArr=new String[26];
        Set<String> set=new HashSet<>();

        String[] sArr=s.split(" ");

        if(pattern.length()!=sArr.length) return false;

        for(int i=0;i<pattern.length();i++){

            char ch=pattern.charAt(i);
            String word=sArr[i];
            int index=ch-'a';

            if(wordArr[index]!=null){
                if(!word.equals(wordArr[index])) return false;
            }
            else{
                if(set.contains(word)) return false;  
                wordArr[index]=word;
                set.add(word);
            }
        }
        return true;
    }
}