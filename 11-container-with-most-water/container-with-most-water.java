class Solution {
    public int maxArea(int[] height) {
        int area=0;
        int start=0;
        int end=height.length-1;
        while(start<end) {
            int currArea=Math.min(height[start], height[end])*(end-start);
            area=Math.max(area, currArea);
            if(height[start]>height[end]) end--;
            else start++;
        }
        return area;
    }
}