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
    public ListNode removeNthFromEnd(ListNode head, int n) {
       int len=0;
       ListNode temp=head;
       while(temp!=null){
        temp=temp.next;
        len++;
       }
       if(n==len) return head.next;
       int req=len-n;
       ListNode prev=head;
       for(int i=1;i<req;i++){
        prev=prev.next;
       }
       prev.next=prev.next.next;
        return head;
    }
}
