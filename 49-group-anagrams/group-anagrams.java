class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map=new HashMap<>();
        for(String str: strs){
            char[] chars=str.toCharArray();
            Arrays.sort(chars);
            String sequence=new String(chars);
            map.computeIfAbsent(sequence, k-> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}