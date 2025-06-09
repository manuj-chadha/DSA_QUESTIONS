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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode temp=dummy;
        for(int i=1;i<left;i++){
            temp=temp.next;
        }
        ListNode prev=null;
        ListNode curr=temp.next;
        for(int i=0;i<=right-left;i++){
            ListNode ri=curr.next;
            curr.next=prev;
            prev=curr;
            curr=ri;
        }
        temp.next.next=curr;
        temp.next=prev;
        return dummy.next;
    }
}