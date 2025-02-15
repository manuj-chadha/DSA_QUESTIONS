class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] arr=new int[nums.length-k+1];
        int index=0;
        Deque<Integer> queue=new ArrayDeque<>();
        for(int i=0;i<k-1;i++){
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            
        }
        for(int i=k-1;i<nums.length;i++){
            while(!queue.isEmpty() && nums[queue.peekLast()]<nums[i]){
                queue.pollLast();
            }
            queue.offerLast(i);
            while(!queue.isEmpty() && queue.peekFirst()<=i-k){
                queue.pollFirst();
            }
            arr[index]=nums[queue.peekFirst()];
            index++;
        }
        return arr;
    }
}