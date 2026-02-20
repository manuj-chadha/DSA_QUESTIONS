class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, Integer> distance=new HashMap<>();
        for(String word: wordList) {
            distance.put(word, Integer.MAX_VALUE);
        }
        if(!distance.containsKey(endWord)) return new ArrayList<>();
        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord);

        HashMap<String, List<String>> parents=new HashMap<>();
        for(int i=0;i<wordList.size();i++) {
            parents.put(wordList.get(i), new ArrayList<>());
        }
        distance.put(beginWord, 0);
        parents.put(beginWord, new ArrayList<>());
        while(!queue.isEmpty()) {
            int n=queue.size();
            boolean endLevel=false;
            for(int a=0;a<n;a++) {
                String word=queue.poll();
                for(int i=0;i<word.length();i++) {
                    for(int j=0;j<26;j++) {
                        char[] ch=word.toCharArray();
                        ch[i]=(char) ('a'+j);
                        String formed=String.valueOf(ch);
                        if(formed.equals(word)) continue;
                        if(distance.containsKey(formed)){
                            if(formed.equals(endWord)) endLevel=true;
                            if(distance.get(formed)==Integer.MAX_VALUE) {
                                distance.put(formed, distance.get(word)+1);
                                List<String> list=parents.get(formed);
                                list.add(word);
                                parents.put(formed, list);
                                queue.add(formed);
                            }
                            else if(distance.get(formed)==distance.get(word)+1){
                                List<String> list=parents.get(formed);
                                list.add(word);
                                parents.put(formed, list);
                            }
                            // ignore for else
                        }
                    }
                }
            }
            if(endLevel) break;
        }
        List<List<String>> ans=new ArrayList<>();
        List<String> path=new ArrayList<>();
        if(distance.get(endWord)==Integer.MAX_VALUE) return new ArrayList<>();
        findList(parents, endWord, beginWord, path, ans);
        for(List<String> list: ans) {
            Collections.reverse(list);
        }
        return ans;
    }
    private void findList(HashMap<String, List<String>> parents, String word, String beginWord, List<String> path, List<List<String>> ans){
        if(word.equals(beginWord)){
            path.add(beginWord);
            ans.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        path.add(word);
        List<String> parent=parents.get(word);
        for(String p: parent) {
            findList(parents, p, beginWord, path, ans);
        }
        path.remove(path.size()-1);
    }
}