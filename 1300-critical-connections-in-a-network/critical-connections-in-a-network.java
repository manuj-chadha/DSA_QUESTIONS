class Solution {
    private int timer=1;
    private void dfs(int index, List<List<Integer>> adj, int[] time, int[] low, int parent, List<List<Integer>> bridges, boolean[] visited){
        time[index]=low[index]=timer;
        timer++;
        visited[index]=true;
        List<Integer> neighbors=adj.get(index);
        for(int i:neighbors){
            if(i==parent) continue;
            if(!visited[i]){
                dfs(i, adj, time, low, index, bridges, visited);
                low[index]=Math.min(low[index], low[i]);
                if(low[i]>time[index]){
                    List<Integer> bridge=new ArrayList<>();
                    bridge.add(index);
                    bridge.add(i);
                    bridges.add(bridge);
                }
            }
            else {
                low[index]=Math.min(low[index], low[i]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<connections.size();i++){
            int i1=connections.get(i).get(0);
            int i2=connections.get(i).get(1);
            adj.get(i1).add(i2);
            adj.get(i2).add(i1);
        }
        int[] time=new int[n];
        int[] low=new int[n];

        boolean[] visited=new boolean[n];
        List<List<Integer>> bridges=new ArrayList<>();
        dfs(0, adj, time, low, -1, bridges, visited);
        return bridges;
    }
}