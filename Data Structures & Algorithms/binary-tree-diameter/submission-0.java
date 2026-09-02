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
    class TreeInfo{
        int ht;
        int dr;
        public TreeInfo(int ht, int dr){
            this.ht=ht;
            this.dr=dr;
        }
    }
    public TreeInfo diameter(TreeNode root){
        if(root==null) return new TreeInfo(0,0);
        TreeInfo left=diameter(root.left);
        TreeInfo right=diameter(root.right);
        int myHt=Math.max(left.ht,right.ht)+1;
        int dr1=left.dr;
        int dr2=right.dr;
        int dr3=left.ht+right.ht;
        int myDr=Math.max(dr1,Math.max(dr2,dr3));
        return new TreeInfo(myHt,myDr);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        TreeInfo ans=diameter(root);
        return ans.dr;
    }
}
