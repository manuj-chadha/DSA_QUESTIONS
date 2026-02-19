class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        if(!set.contains(endWord)) return 0;
        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord);
        if(set.contains(beginWord)) set.remove(beginWord);
        int len=1;
        while (!queue.isEmpty()) {
            int n=queue.size();
            for(int a=0;a<n;a++) {
                String word=queue.poll();
                for(int i=0;i<word.length();i++){
                    for(int j=0;j<26;j++) {
                        String formed=word.substring(0, i)+ (char) ('a'+j) + word.substring(i+1, word.length());
                        if(formed.equals(endWord)){
                            return len+1;
                        }
                        if(set.contains(formed)){
                            queue.add(formed);
                            set.remove(formed);
                        }
                    }
                }
            }
            if(!queue.isEmpty()) len++;
        }
        return 0;
    }
}