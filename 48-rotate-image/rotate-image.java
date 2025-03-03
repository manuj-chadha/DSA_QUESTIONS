class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        if(n==1) return;
        int start=0;
        int end=n-1;
        while(start<end){
            for(int i=0;i<n;i++){
                swap(matrix, start, i, end, i);
            }
            start++;
            end--;
        }
        
        for(int i=1;i<n;i++){
            int r=i;
            int c=i;
            while(r<n && c<n){
                swap(matrix, i-1, r, c, i-1);
                r++;
                c++;
            }
        }
    }
    void swap(int[][] matrix, int r1, int c1, int r2, int c2){
        int temp=matrix[r1][c1];
        matrix[r1][c1]=matrix[r2][c2];
        matrix[r2][c2]=temp;
    }
}