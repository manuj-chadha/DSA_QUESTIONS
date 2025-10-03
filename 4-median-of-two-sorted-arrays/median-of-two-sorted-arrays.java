class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;
        if(n1>n2) return findMedianSortedArrays(nums2, nums1);
        int n=(n1+n2+1) >> 1;
        int left=0;
        int right=n1;
        while(left<=right){
            int l1=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE;
            int l2=Integer.MIN_VALUE;
            int r2=Integer.MAX_VALUE;
            int mid1=(left+right) >> 1;
            int mid2=n-mid1;
            if((mid1)<n1) r1=nums1[mid1];
            if((mid2)<n2) r2=nums2[mid2];
            if((mid1-1)>=0) l1=nums1[mid1-1];
            if((mid2-1)>=0) l2=nums2[mid2-1];

            if(l1<=r2 && l2<=r1){
                if(((n1+n2)&1)==1) return Math.max(l1, l2);
                else return (Math.max(l1, l2)+Math.min(r1, r2))/2.0;
            }
            else if(l1>r2) right=mid1-1;
            else left=mid1+1;
        }
        return 0;
    }
}