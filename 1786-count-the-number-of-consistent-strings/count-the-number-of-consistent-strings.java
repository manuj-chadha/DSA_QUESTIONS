class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> hash=new HashSet<>();
        int count=0;
        for(int i=0;i<allowed.length();i++){
            hash.add(allowed.charAt(i));
        }
        for(int i=0;i<words.length;i++){
            boolean isConsistent=true;
            for(int j=0;j<words[i].length();j++){
                if(!hash.contains(words[i].charAt(j))){
                    isConsistent=false;
                    break;
                }
            }
            if(isConsistent) count++;
        }
        return count;
    }
}