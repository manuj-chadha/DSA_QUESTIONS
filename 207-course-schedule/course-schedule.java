class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] i: prerequisites){
            adj.get(i[1]).add(i[0]);
        }
        boolean[] visited=new boolean[numCourses];
        boolean[] pathVisited=new boolean[numCourses];
        for(int i=0;i<numCourses;i++) {
            if(!visited[i]) {
                if(!canFinish(adj, i, visited, pathVisited)) return false;
            }
        }
        return true;
    }
    private boolean canFinish(List<List<Integer>> adj, int node, boolean[] visited, boolean[] pathVisited){
        visited[node]=true;
        pathVisited[node]=true;
        List<Integer> neighbors=adj.get(node);
        for(int neighbor: neighbors) {
            if(!visited[neighbor]){
                if(!canFinish(adj, neighbor, visited, pathVisited)) return false;
            }
            if(pathVisited[neighbor]){
                return false;
            }
        }
        pathVisited[node]=false;
        return true;
    }
}
