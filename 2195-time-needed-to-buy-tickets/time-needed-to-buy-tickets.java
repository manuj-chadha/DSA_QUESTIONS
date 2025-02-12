class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        Queue<Integer> queue=new LinkedList<>();
        for (int i = 0; i < tickets.length; i++) {
            queue.offer(i);
        }
        while(tickets[k]!=0){
            int val=queue.poll();
            tickets[val]--;
            if(tickets[val]>0) queue.offer(val);
            time++;
        }
        return time;
    }
}