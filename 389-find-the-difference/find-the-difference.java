import java.util.Hashtable;
class Solution {
    public char findTheDifference(String s, String t) {
        Hashtable<Character, Integer> hash=new Hashtable<>();
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(hash.containsKey(ch)){
                hash.put(ch, hash.get(ch)+1);
            }
            else{
                hash.put(ch, 1);
            }
        }
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int val=hash.get(ch);
            if(val==1){
                hash.remove(ch);
            }
            else{
                hash.put(ch, val-1);
            }
        }
        Character singleValue = hash.keySet().iterator().next();
        return singleValue;
    }
}