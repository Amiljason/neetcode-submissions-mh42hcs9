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
    public int globalMax=Integer.MIN_VALUE;
    public int dfs(TreeNode root){
        if(root == null) return 0;
        int leftSum=Math.max(0,dfs(root.left));
        int rightSum=Math.max(0,dfs(root.right));
        int currSum=root.val+leftSum+rightSum;
        globalMax=Math.max(globalMax, currSum) ;
        return root.val+Math.max(leftSum,rightSum);
    }
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return globalMax;
    }
}
