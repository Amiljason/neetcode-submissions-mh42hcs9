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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val==q.val) return p;
        int rV=root.val;
        if(rV == p.val || rV == q.val) return root;
        else if((p.val< rV) && (rV < q.val) || (q.val< rV) && (rV <p.val)) return root;
        else if(p.val<rV && q.val<rV){
            return lowestCommonAncestor(root.left,p,q);
        }
        else return lowestCommonAncestor(root.right,p,q);

    }
}
