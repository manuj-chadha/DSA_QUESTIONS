class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map=new HashMap<>();
        for(String str: strs){
            int[] arr=new int[26];
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<str.length();i++){
                char ch=str.charAt(i);
                int index=ch-'a';
                arr[index]+=1;
            }
            for(int i: arr){
                sb.append(i +"#");
            }
            String sequence=sb.toString();
            
            map.computeIfAbsent(sequence, k-> new ArrayList<>()).add(str);
        }
        List<List<String>> list=new ArrayList<>();
        for (List<String> group : map.values()) {
            list.add(group);
        }
        return list;
    }
}