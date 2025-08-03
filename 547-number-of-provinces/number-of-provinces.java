class DisjointSet {
    ArrayList<Integer> size=new ArrayList<>();
    ArrayList<Integer> parent=new ArrayList<>();

    public DisjointSet(int n) {
        for(int i=0;i<=n;i++){
            size.add(1);
            parent.add(i);
        }
    }

    public int findParent(int n){
        if(n==parent.get(n)) return n;
        int node=findParent(parent.get(n));
        parent.set(n, node);
        return node;
    }

    public void unionBySize(int a, int b){
        int ulp_a=findParent(a);
        int ulp_b=findParent(b);
        if(ulp_a==ulp_b) return;
        if(size.get(ulp_a)>size.get(ulp_b)){
            parent.set(ulp_b, ulp_a);
            size.set(ulp_a, size.get(ulp_b)+size.get(ulp_a));
        }
        else {
            parent.set(ulp_a, ulp_b);
            size.set(ulp_b, size.get(ulp_b)+size.get(ulp_a));
        }
    }

}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        DisjointSet ds=new DisjointSet(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    ds.unionBySize(i, j);
                }
            }
        }
        int provinces=0;
        for(int i=0;i<n;i++){
            if(ds.findParent(i)==i) provinces++;
        }
        return provinces;
    }
}