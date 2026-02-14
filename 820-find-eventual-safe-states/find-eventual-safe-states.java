class Solution {
    List<Integer> ans;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ans=new ArrayList<>();
        boolean[] visited=new boolean[graph.length];
        boolean[] pathVisited=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                eventualSafe(graph, i, visited, pathVisited);
            }
        }
        Collections.sort(ans);
        return ans;
    }
    private boolean eventualSafe(int[][] graph, int i, boolean[] visited, boolean[] pathVisited){
        visited[i]=true;
        pathVisited[i]=true;
        int[] neighbors=graph[i];
        for(int a=0;a<neighbors.length;a++) {
            if(!visited[neighbors[a]]){
                if(!eventualSafe(graph, neighbors[a], visited, pathVisited)) return false;
            }
            else if(pathVisited[neighbors[a]]){
                return false;
            }
        }
        pathVisited[i]=false;
        ans.add(i);
        return true;
    }
}