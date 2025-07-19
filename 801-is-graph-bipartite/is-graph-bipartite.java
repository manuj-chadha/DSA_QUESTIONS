class Solution {
    public boolean isBipartite(int[][] graph) {
        int m=graph.length;
        int[] coloured=new int[m];
        Arrays.fill(coloured, -1);
        for(int i=0;i<m;i++){
            if(coloured[i]==-1){
                if(!dfs(graph, coloured, i, 0)) return false;
            }
        }
        return true;
    }
    private boolean dfs(int[][] graph, int[] coloured, int node, int color){
        if(coloured[node]==-1){
            coloured[node]=color;
            int[] arr=graph[node];
            for(int val: arr){
                if(coloured[node]==coloured[val]) return false;
                if(coloured[val]==-1){
                    if(!dfs(graph, coloured, val, color ^ 1)) return false;
                }
            }
        }
        return true;
    }
}