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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }
        ListNode middle=middleOfList(head);
        ListNode headS=reverseList(middle.next);
        middle.next=null;
        ListNode headF=head;
        while(headF!=null && headS!=null){
            ListNode temp=headF.next;
            headF.next=headS;
            headF=temp;
            temp=headS.next;
            headS.next=headF;
            headS=temp;
        }
        if(headF!=null) headF=null;
    }
    private ListNode middleOfList(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    private ListNode reverseList(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}