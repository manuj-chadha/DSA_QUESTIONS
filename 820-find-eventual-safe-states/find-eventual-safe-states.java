class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int[] state=new int[n];
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(state[i]==0){
                eventualSafe(i, graph, state);
            }
        }
        for(int i=0;i<state.length;i++){
            if(state[i]==2) ans.add(i);
        }
        return ans;
    }
    private boolean eventualSafe(int i, int[][] graph, int[] state) {
        if(state[i]==1) return false;
        if(state[i]==2) return true;
        state[i]=1;
        int[] neighbors=graph[i];
        for(int neighbor: neighbors) {
            if(!eventualSafe(neighbor, graph, state)) return false;
        }
        state[i]=2;
        return true;
    }
}