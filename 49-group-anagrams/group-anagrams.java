class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map=new HashMap<>();
        for(String str: strs){
            char[] ch=str.toCharArray();
            Arrays.sort(ch);
            String string=new String(ch);
            map.computeIfAbsent(string, s -> new ArrayList<>()).add(str);
        }
        List<List<String>> list=new ArrayList<>();
        for(List<String> li : map.values()){
            list.add(li);
        }
        return list;
    }
} 