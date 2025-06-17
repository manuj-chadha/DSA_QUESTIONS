class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map=new HashMap<>();
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            char tch=t.charAt(i);
            if(map.containsKey(ch)){
                if(map.get(ch)!=tch) return false;
                else continue;
            }
            else{
                if(set.contains(tch)) return false;
                map.put(ch, tch);
                set.add(tch);
            }
        }
        return true;
    }
}