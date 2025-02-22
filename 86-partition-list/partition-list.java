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
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead=new ListNode(-1);
        ListNode smaller=smallHead;
        ListNode bigHead=new ListNode(-1);
        ListNode bigger=bigHead;
        ListNode node=head;
        while(node!=null){
            if(node.val<x){
                smaller.next=node;
                smaller=smaller.next;
            }
            else{
                bigger.next=node;
                bigger=bigger.next;
            }
            node=node.next;
        }
        bigger.next=null;
        smaller.next=bigHead.next;
        
        return smallHead.next;
    }
}