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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode curr=dummy;
        ListNode temp=head;
        while(temp!=null){
            if(temp.next!=null && temp.val==temp.next.val){
                while(temp.next!=null && temp.next.val==temp.val) temp=temp.next;
                temp=temp.next;
                curr.next=temp;
            }
            else{
                curr=curr.next;
                temp=temp.next;
            }
        }
        return dummy.next;
    }
}