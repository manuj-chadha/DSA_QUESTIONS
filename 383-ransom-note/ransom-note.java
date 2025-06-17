class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letterCount=new int[26];

        for(char ch: magazine.toCharArray()){
            letterCount[ch-'a']++;
        }
        for(char ch: ransomNote.toCharArray()){
            if(letterCount[ch-'a']==0) return false;
            letterCount[ch-'a']--;
        }
        return true;

    }
}
