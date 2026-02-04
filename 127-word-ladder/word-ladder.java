class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue=new LinkedList<>();
        HashSet<String> set=new HashSet<>();
        for(String word: wordList) set.add(word);
        if(!set.contains(endWord)) return 0;
        if(set.contains(beginWord)) set.remove(beginWord);
        queue.add(beginWord);
        int shortest=1;
        while(!queue.isEmpty()){
            int n=queue.size();
            shortest++;
            for(int a=0;a<n;a++){
                String word=queue.poll();
                for(int i=0;i<word.length();i++){
                    for(int j=0;j<26;j++){
                        String formed=word.substring(0, i)+(char)('a'+j)+word.substring(i+1, word.length());
                        if(set.contains(formed)){
                            if(formed.equals(endWord)) return shortest;
                            queue.add(formed);
                            set.remove(formed);
                        }
                    }
                }
            }
        }
        return 0;
    }
}