class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            ans.add(new ArrayList<>());
        }
        ans.get(0).add(1);
        if(numRows==1) return ans;
        ans.get(1).add(1);
        ans.get(1).add(1);
        for(int i=2;i<numRows;i++) {
            ans.get(i).add(1);
            for(int j=1;j<i;j++){
                int left=ans.get(i-1).get(j-1);
                int right=ans.get(i-1).get(j);
                ans.get(i).add(left+right);
            }
            ans.get(i).add(1);
        }
        return ans;
    }
}