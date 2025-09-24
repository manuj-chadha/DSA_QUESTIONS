class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<>();
        for(int i: nums){
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }
            else {
                map.put(i, 1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq=new PriorityQueue<>((a, b) -> a.getValue()-b.getValue());
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.add(entry);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] elements=new int[k];
        int i=0;
        while(!pq.isEmpty()){
            elements[i++]=pq.poll().getKey();
        }
        return elements;
    }
}