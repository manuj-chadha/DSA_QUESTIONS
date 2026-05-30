class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> nonOvl=new ArrayList<>();
        int i=0;
        while(i<intervals.length){
            int start=intervals[i][0];
            int end=intervals[i][1];
            int j=i+1;
            while(j<intervals.length && intervals[j][0]<=end){
                end=Math.max(end, intervals[j][1]);
                j++;
            }
            nonOvl.add(new int[]{start, end});
            i=j;
        } 
        int[][] ans=new int[nonOvl.size()][2];
        int index=0;
        for(int[] arr: nonOvl){
            ans[index][0]=arr[0];
            ans[index][1]=arr[1];
            index++;
        }
        return ans;
    }
}