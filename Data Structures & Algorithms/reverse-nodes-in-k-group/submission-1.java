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
        if(head==null||k==1) return head;
        List<Integer> l=new ArrayList<>();
        ListNode curr=head;
        ListNode temp=head;
        int start=0;
        while(curr!=null){
            while(start<k && temp!=null){
                l.add(temp.val);
                temp=temp.next;
                start++;
            }
            if(l.size()<k) break;
            Collections.reverse(l);
            for(int num:l){
                curr.val=num;
                curr=curr.next;
            }
            start=0;
            temp=curr;
            l.clear();
        }
        return head;
    }
}
