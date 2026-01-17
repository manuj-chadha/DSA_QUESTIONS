class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map=new HashMap<>();
        int maxFruits=0;
        int left=0;
        int right=0;
        while(right<fruits.length){
            int fruit=fruits[right];
            map.put(fruit, map.getOrDefault(fruit, 0)+1);
            while(map.size()>2){
                int prevFruit=fruits[left];
                map.put(prevFruit, map.get(prevFruit)-1);
                if(map.get(prevFruit)==0) map.remove(prevFruit);
                left++;
            }
            maxFruits=Math.max(maxFruits, right-left+1);
            right++;
        }
        return maxFruits;
    }
}