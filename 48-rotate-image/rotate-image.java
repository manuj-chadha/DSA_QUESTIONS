class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int col=0;col<n;col++){
            int i=0;
            int j=n-1;
            while(i<j){
                swap(matrix, col, col, i++, j--);
            }
        }
        for(int offset=0;offset<n;offset++){
            for(int j=offset;j<n;j++){
                swap(matrix, j, offset, offset, j);
            }
        }
    }
    private void swap(int[][] matrix, int col1, int col2, int i, int j){
        int temp=matrix[i][col1];
        matrix[i][col1]=matrix[j][col2];
        matrix[j][col2]=temp;
    }
}