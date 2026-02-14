class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] safe=new int[graph.length];
        boolean[] visited=new boolean[graph.length];
        boolean[] pathVisited=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!visited[i]){
                eventualSafe(graph, i, visited, pathVisited, safe);
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<safe.length;i++){
            if(safe[i]==1) ans.add(i);
        }
        return ans;
    }
    private boolean eventualSafe(int[][] graph, int i, boolean[] visited, 
    boolean[] pathVisited, int[] safe){
        visited[i]=true;
        pathVisited[i]=true;
        int[] neighbors=graph[i];
        for(int neighbor: neighbors) {
            if(!visited[neighbor]){
                if(!eventualSafe(graph, neighbor, visited, pathVisited, safe)){
                    safe[neighbor]=2;
                    return false;
                }
            }
            else {
                if(pathVisited[neighbor]){
                    safe[neighbor]=2;
                    return false;
                }
                else if(safe[neighbor]==2) return false;
            } 
        }
        safe[i]=1;
        pathVisited[i]=false;
        return true;
    }
}