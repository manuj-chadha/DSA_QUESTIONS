class Solution {
    public int maximumLength(int[] nums) {
        int max=1;
        HashMap<Long, Integer> map=new HashMap<>();
        for(int num: nums){
            map.put((long) num, map.getOrDefault((long) num, 0) +1);
        }
        int ones=map.getOrDefault(1L, 0);
        ones=(ones & 1) == 1 ? ones : ones-1;
        max=Math.max(max, ones);
        // System.out.println(map);
        map.remove(1L);
        for(Long num: map.keySet()){
            Long n=num;
            int count=0;
            while(map.containsKey(n) && map.get(n)>1){
                n*=n;
                count+=2;
            }
            if(map.containsKey(n)){
                count++;
            } else count--;
            max=Math.max(max, count);
        }
        return max; 
    }
}