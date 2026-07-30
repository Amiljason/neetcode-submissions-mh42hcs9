/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> order=new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> l=new ArrayList<>();
            for(int i=q.size();i>0;i--){//imp
                TreeNode curr=q.poll();
                if(curr!=null){
                    l.add(curr.val);
                    q.offer(curr.left);
                    q.offer(curr.right);  
                }
            }
            if(l.size()>0){
                order.add(l);
            }
        }
        return order;
    }
}
