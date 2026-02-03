class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==1) return intervals;
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        int start=intervals[0][0];
        int val=intervals[0][1];
        List<int[]> ans=new ArrayList<>();
        int i=1;
        while(i<intervals.length) {
            while(i<intervals.length && intervals[i][0]<=val){
                val=Math.max(val, intervals[i][1]);
                i++;
            }
            ans.add(new int[]{start, val});
            if(i<intervals.length){
                start=intervals[i][0];
                val=intervals[i][1];
            }
        }
        int[][] arr=new int[ans.size()][2];
        for(int a=0;a<arr.length;a++){
            arr[a]=ans.get(a);
        }
        return arr;
    }
}