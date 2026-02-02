class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer> queue=new ArrayDeque<>();
        int[] ans=new int[n-k+1];
        int ind=0;
        for(int i=0;i<nums.length;i++) {
            while(!queue.isEmpty() && queue.peekFirst()<i-k+1){
                queue.removeFirst();
            }
            while(!queue.isEmpty() && nums[queue.peekLast()]<=nums[i]){
                queue.removeLast();
            }
            queue.addLast(i);
            if(i>=k-1) ans[ind++]=nums[queue.peekFirst()];
        }
        return ans;
    }
}