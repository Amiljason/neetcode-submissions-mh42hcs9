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
// the ans is the right most node in each level;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode rightSide=null;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node!=null){
                    rightSide=node;
                    if(node.left !=null) q.offer(node.left);
                    if(node.right!=null) q.offer(node.right);
                }
            }
            if(rightSide!=null) ans.add(rightSide.val);
        }
        return ans;
    }
}
