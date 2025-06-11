/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode groupPrev=dummy;
        while(true){
            ListNode check=groupPrev;
            for(int i=0;i<k;i++){
                check=check.next;
                if(check==null) return dummy.next;
            }
            ListNode groupStart=groupPrev.next;
            ListNode prev=null;
            ListNode curr=groupStart;
            for(int i=0;i<k;i++){
                ListNode nxt=curr.next;
                curr.next=prev;
                prev=curr;
                curr=nxt;
            }
            groupStart.next=curr;
            groupPrev.next=prev;
            groupPrev=groupStart;
        }
    }
}