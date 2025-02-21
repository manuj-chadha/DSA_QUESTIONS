class Solution {
    public boolean find132pattern(int[] nums) {
        int secondLargest=Integer.MIN_VALUE;
        Stack<Integer> stack=new Stack<>();
        int i=nums.length-1;
        while(i>=0){
            if(nums[i]<secondLargest){
                return true;
            }
            while(!stack.isEmpty() && nums[i]>stack.peek()){
                secondLargest=stack.pop();
            }
            stack.push(nums[i]);
            i--;
        }
        return false;
    }
}