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
        if(head==null || head.next==null) return null;
        int len=0;
        ListNode t=head;
        while(t!=null){
            len++;
            t=t.next;
        }
        ListNode prev=new ListNode(-1);
        prev.next=head;
        ListNode curr=head;
        int pos=len-n,i=0;
        while(i!=pos){
            i++;
            prev=curr;
            curr=curr.next;
        }
        if(curr.next!=null){
            prev.next=curr.next;
            curr.next=null;
        }
        else prev.next=null;
        return pos==0?prev.next:head;

    }
}
