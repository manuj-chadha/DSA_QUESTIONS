public class Pair {
    String first;
    int second;
    Pair (String first, int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue=new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));
        Set<String> set=new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        while(!queue.isEmpty()){
            Pair element=queue.poll();
            String word=element.first;
            int steps=element.second;
            if(word.equals(endWord)) return steps;
            for(int i=0;i<word.length();i++){
                for(char ch='a'; ch<='z'; ch++){
                    char[] charArray=word.toCharArray();
                    charArray[i]=ch;
                    String str=new String(charArray);
                    if(set.contains(str)){
                        queue.offer(new Pair(str, steps+1));
                        set.remove(str);
                    }
                }
            }
        }
        return 0;
    }
}