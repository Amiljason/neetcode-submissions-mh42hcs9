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
    int count=0;
    public void dfs(TreeNode root, int maxSoFar){
        if(root==null) return;
        if(root.val>=maxSoFar) count++;
        maxSoFar=Math.max(root.val,maxSoFar);
        if(root.left!=null) dfs(root.left,maxSoFar);
        if(root.right!=null) dfs(root.right,maxSoFar);
    }
    public int goodNodes(TreeNode root) {
        int maxSoFar=root.val;
        dfs(root,maxSoFar);
        return count;
    }
}
