class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map=new HashMap<>();
        for(String s: strs){
            char[] cha=s.toCharArray();
            Arrays.sort(cha);
            String word=new String(cha);
            if(map.containsKey(word)){
                List<String> words=map.get(word);
                words.add(s);
                map.put(word, words);
            }
            else {
                List<String> list=new ArrayList<>();
                list.add(s);
                map.put(word, list);
            }
        }
        List<List<String>> li=new ArrayList<>();
        for(List<String> s: map.values()){
            li.add(s);
        }
        return li;
    }
}