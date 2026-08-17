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
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead=new ListNode(-1, head);
        ListNode prev=dummyHead;
        ListNode temp=head;
        while(temp!=null && temp.next!=null) {
            ListNode nextNode=temp.next;
            prev.next=nextNode;
            temp.next=nextNode.next;
            nextNode.next=temp;
            prev=temp;
            temp=temp.next;
        }
        return dummyHead.next;
    }
}