class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)-> (b-a));
        for(int gift: gifts){
            maxHeap.add(gift);
        }
        while(k>0){
            int out=(int)Math.floor(Math.sqrt(maxHeap.poll()));
            maxHeap.add(out);
            k--;
        }
        long sum=0;
        while(!maxHeap.isEmpty()){
            sum+=maxHeap.poll();
        }
        return sum;
    }
}