class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map=new HashMap<>();
        for(String str: strs){
            char[] chars=str.toCharArray();
            Arrays.sort(chars);
            String sequence=new String(chars);
            map.computeIfAbsent(sequence, k-> new ArrayList<>()).add(str);
        }
        List<List<String>> list=new ArrayList<>();
        for(List<String> group : map.values()){
            list.add(group);
        }
        return list;
    }
}