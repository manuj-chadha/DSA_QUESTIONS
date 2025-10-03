class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(target<matrix[0][0] || target> matrix[matrix.length-1][matrix[0].length-1]) return false;
        int start=0;
        int end=matrix.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(matrix[mid][0]>target) end=mid-1;
            else start=mid+1;
        }
        int s=0;
        int e=matrix[0].length-1;
        while(s<=e){
            int mid=(s+e)/2;
            if(matrix[end][mid]==target) return true;
            else if(matrix[end][mid]>target) e=mid-1;
            else s=mid+1;
        }
        return false;
    }
}