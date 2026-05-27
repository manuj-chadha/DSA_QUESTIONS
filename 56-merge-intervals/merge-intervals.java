class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans=new ArrayList<>();
        Arrays.sort(intervals, (a, b)-> a[0]-b[0]);
        int i=0;
        while(i<intervals.length){
            int low=intervals[i][0];
            int high=intervals[i][1];
            int j=i+1;
            while(j<intervals.length && intervals[j][0]<=high){
                high=Math.max(high, intervals[j][1]);
                j++;
            }
            ans.add(new int[]{low, high});
            i=j;
        }
        int[][] arr=new int[ans.size()][2];
        i=0;
        for(int[] a: ans){
            arr[i][0]=a[0];
            arr[i][1]=a[1];
            i++;
        }
        return arr;
    }
}