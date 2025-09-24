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
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int j = 0; j <= nums.length; j++) {
            bucket[j] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            bucket[entry.getValue()].add(entry.getKey());
        }
        int[] elements=new int[k];
        int i=0;
        int bucketIndex=nums.length;
        while(k>0){
            for(Integer ele: bucket[bucketIndex]){
                elements[i++]=ele;
                k--;    
            }
            if(k==0) break;
            bucketIndex--;
        }
        return elements;
    }
}