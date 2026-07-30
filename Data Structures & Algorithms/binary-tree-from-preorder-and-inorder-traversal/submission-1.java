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
    int preIdx=0;
    HashMap<Integer,Integer> map= new HashMap<>();
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        for(int i=0;i<inOrder.length;i++){
            map.put(inOrder[i],i);
        }
        return dfs(preOrder,0,inOrder.length-1);
    }
    private TreeNode dfs(int[] preOrder,int l,int r){
        if(l>r) return null;
        int rV = preOrder[preIdx];
        preIdx++;
        TreeNode root = new TreeNode(rV);
        int mid = map.get(rV);
        root.left=dfs(preOrder,l,mid-1);
        root.right=dfs(preOrder,mid+1,r);
        return root;
    }
}
