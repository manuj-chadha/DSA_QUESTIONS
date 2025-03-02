class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        int columns=matrix[0].length;
        if(target<matrix[0][0]) return false;
        if(target>matrix[rows-1][columns-1]) return false;
        
        int low=0;
        int high=rows-1;
        while(low<=high){
            if(target>=matrix[low][0] && target<=matrix[low][columns-1]){
                return binarySearch(matrix[low], target);
            }
            else{
                low++;
            }
        }
        return false;

    }

    public boolean binarySearch(int[] nums, int target) {
        int end=nums.length-1;
        int start=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target) return true;
            else if(nums[mid]>target) end=mid-1;
            else start=mid+1;
        }
        return false;
    }
}