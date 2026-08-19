class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int ans=0;
        HashMap<Integer, HashSet<Integer>> map=new HashMap<>();
        for(int[] i: reservedSeats) {
            HashSet<Integer> rowSet=map.getOrDefault(i[0], new HashSet<>());
            rowSet.add(i[1]);
            map.put(i[0], rowSet);
        }
        int emptyRows=n-map.size();
        ans+=emptyRows*2;
        int[][] seatBlocks={{2, 3, 4, 5}, {4, 5, 6, 7}, {6, 7, 8, 9}};
        for(HashSet<Integer> set: map.values()){
            int count=0;
            for(int[] block: seatBlocks) {
                boolean valid=true;
                for(int seat: block) {
                    if(set.contains(seat)){
                        valid=false;
                        break;
                    }
                }
                if(valid){
                    count++;
                    for(int num: block) set.add(num);
                }
            }
            ans+=count;
        }
        return ans;
    }
}