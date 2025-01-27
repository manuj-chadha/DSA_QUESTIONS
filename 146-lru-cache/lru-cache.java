class LRUCache {
    int capacity=0;
    LinkedHashMap<Integer, Integer> hashMap;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        hashMap=new LinkedHashMap<>(capacity, 0.75f , true);
    }

    public int get(int key) {
        return hashMap.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if(hashMap.containsKey(key)){
            hashMap.put(key, value);
        }
        else{
            if (hashMap.size() == capacity) {
                Integer firstKey = hashMap.keySet().iterator().next();
                hashMap.remove(firstKey);
            }
            hashMap.put(key, value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */