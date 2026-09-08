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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0) return null;
        ListNode dummy=new ListNode(-1);
        ListNode tail=dummy;
        PriorityQueue<ListNode> pQ=new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        for(ListNode list:lists){
            if(list!=null){
                pQ.offer(list);   
            }
        }
        while(!pQ.isEmpty()){
            ListNode curr=pQ.poll();
            tail.next=curr;
            tail=tail.next;
            if(curr.next!=null){
            curr=curr.next;
            pQ.offer(curr);
            } 
        }
        return dummy.next;
    }
}
