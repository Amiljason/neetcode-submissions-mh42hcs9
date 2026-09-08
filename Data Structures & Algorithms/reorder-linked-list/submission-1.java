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
    public ListNode reverseList(ListNode head) {

        if(head == null|| head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }
    public void reorderList(ListNode head) {
        ListNode t=head;
        int len=0;
        while(t!=null){
            len++;
            t=t.next;
        }
        int mid=len/2;
        ListNode fH=head;
        ListNode temp=head;
        ListNode tSH=head;
        int pos=0;
        while(pos!=mid){
            pos++;
            temp=temp.next;
            tSH=tSH.next;
        }
        tSH=tSH.next;
        temp.next=null;
        ListNode sH = reverseList(tSH);
        while(sH!=null){
            ListNode n1=fH.next;
            ListNode n2=sH.next;
            sH.next=n1;
            fH.next=sH;
            sH=n2;
            fH=n1;
        } 
    }
}
