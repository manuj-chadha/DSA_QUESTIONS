class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)-> (b-a));
        for(int stone: stones){
            maxHeap.add(stone);
        }
        while(maxHeap.size()>1){
            int out=Math.abs(maxHeap.poll()-maxHeap.poll());
            if(out!=0) maxHeap.add(out);
        }
        if(maxHeap.isEmpty()) return 0;
        return maxHeap.poll();
    }
}