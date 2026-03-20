class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowEnd=matrix.length-1;
        int colEnd=matrix[0].length-1;
        int rowStart=0;
        int colStart=0;
        List<Integer> ans=new ArrayList<>();
        while(rowStart<=rowEnd && colStart<=colEnd){
            for(int i=colStart;i<=colEnd;i++){
                ans.add(matrix[rowStart][i]);
            }
            for(int i=rowStart+1;i<rowEnd;i++){
                ans.add(matrix[i][colEnd]);
            }
            if(rowStart!=rowEnd){
                for(int i=colEnd;i>=colStart;i--){
                    ans.add(matrix[rowEnd][i]);
                }
            }
            if(colStart!=colEnd){
                for(int i=rowEnd-1;i>rowStart;i--){
                    ans.add(matrix[i][colStart]);
                }
            }
            rowStart++;
            colStart++;
            rowEnd--;
            colEnd--;
        }
        return ans;
    }
}