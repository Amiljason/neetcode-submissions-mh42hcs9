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
        if(head==null) return null;
        if(head.next==null) return head;
        ListNode temp=head;
        List<Integer> l=new ArrayList<>();
        while(temp!=null){
            l.add(temp.val);
            temp=temp.next;
        }
        
        ListNode curr=head;
        int i=l.size()-1;
        while(curr!=null){
            curr.val=l.get(i);
            curr=curr.next;
            i--;
        }
        return head;
    }
}
