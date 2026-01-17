class Solution {
    public int numberOfSubstrings(String s) {
        int size=s.length();
        int substrings=0;
        int left=0;
        int right=0;
        HashMap<Character, Integer> map=new HashMap<>();
        while(right<s.length()){
            char ch=s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            while(map.size()==3){
                char chLeft=s.charAt(left);
                substrings+=size-right;
                System.out.println(size-right);
                map.put(chLeft, map.get(chLeft)-1);
                if(map.get(chLeft)==0) map.remove(chLeft);
                left++;
            }
            right++;
        }
        return substrings;
    }
}