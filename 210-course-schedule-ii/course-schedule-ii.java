class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> list=new ArrayList<>();
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree=new int[numCourses];
        for(int[] i: prerequisites){
            adj.get(i[1]).add(i[0]);
            indegree[i[0]]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++) {
            if(indegree[i]==0) queue.add(i);
        }
        while(!queue.isEmpty()) {
            int n=queue.size();
            for(int i=0;i<n;i++){
                int node=queue.poll();
                list.add(node);
                List<Integer> neighbors=adj.get(node);
                for(Integer neighbor: neighbors) {
                    if(--indegree[neighbor]==0) queue.add(neighbor);
                }
            }
        }
        if(list.size()!=numCourses) return new int[0];
        return list.stream().mapToInt(i -> i).toArray();
    }
}