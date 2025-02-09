class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map=new HashMap<>();
        int total=t.length();
        for(int i=0;i<total;i++){
            char ch=t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int start=0;
        int end=0;
        int size=Integer.MAX_VALUE;
        int index=-1;
        
        while(end<s.length()){
            char ch=s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0)-1);
            if(map.get(ch)>=0) total--;
            while(total==0 && start<=end){
                if(size>end-start+1){
                    size=end-start+1;
                    index=start;
                }
                char c=s.charAt(start);
                map.put(c, map.get(c)+1);
                if(map.get(c)>0){
                    total++;
                } 
                start++;
            }
            end++;
        }
        if(size==Integer.MAX_VALUE) return "";
        return s.substring(index, index+size);
    }
}