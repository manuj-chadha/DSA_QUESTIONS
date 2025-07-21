class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int m=graph.length;
        boolean[] visited=new boolean[m];
        boolean[] pathVisited=new boolean[m];
        int[] safe=new int[m];
        for(int i=0;i<m;i++){
            if(!visited[i]){
                dfs(graph, visited, pathVisited, safe, i);
            }
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<safe.length;i++){
            if(safe[i]==1) list.add(i);
        }
        return list;
    }
    private boolean dfs(int[][] graph, boolean[] visited, boolean[] pathVisited, int[] safe, int i){
        visited[i]=true;
        pathVisited[i]=true;
        int[] list=graph[i];
        for(int val: list){
            if(!visited[val]){
                if(!dfs(graph, visited, pathVisited, safe, val)){
                    return false;
                }
            }
            else if(pathVisited[val]) return false;
        }
        pathVisited[i]=false;
        safe[i]=1;
        return true;
    }
}