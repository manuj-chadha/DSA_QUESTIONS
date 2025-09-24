class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr=new int[26];
        for(int ch=0;ch<s.length();ch++){
            arr[s.charAt(ch)-'a']++;
        }
        for(int ch=0;ch<t.length();ch++){
            arr[t.charAt(ch)-'a']--;
        }
        for(int i: arr){
            if(i!=0) return false;
        }
        return true;
    }
}