class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<graph.length;i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree=new int[graph.length];
        for(int i=0;i<graph.length;i++) {
            int[] arr=graph[i];
            for(int j=0;j<arr.length;j++){
                adj.get(arr[j]).add(i);
                indegree[i]++;
            }
        }
        int[] safe=new int[graph.length];
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0) queue.add(i);
        }
        while(!queue.isEmpty()) {
            int n=queue.size();
            for(int i=0;i<n;i++){
                int node=queue.poll();
                safe[node]=1;
                List<Integer> neighbors=adj.get(node);
                for(Integer neighbor: neighbors) {
                    if(--indegree[neighbor]==0){
                        queue.add(neighbor);
                    }
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<safe.length;i++){
            if(safe[i]==1) ans.add(i);
        }
        return ans;
    }
}