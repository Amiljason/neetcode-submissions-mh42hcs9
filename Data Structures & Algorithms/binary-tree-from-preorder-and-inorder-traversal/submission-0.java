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
    
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if(preOrder.length!=inOrder.length) return null;
        if(preOrder.length==0 || inOrder.length==0) return null;
        TreeNode root=new TreeNode(preOrder[0]);
        int mid=-1;
        for(int i=0;i<inOrder.length;i++){
            if(inOrder[i]==root.val){
                mid=i;
                break;
            }
        }
        int[] leftPre = Arrays.copyOfRange(preOrder,1,mid+1);
        int[] leftIn =  Arrays.copyOfRange(inOrder,0,mid);
        root.left=buildTree(leftPre,leftIn);
        int[] rightPre = Arrays.copyOfRange(preOrder,mid+1,preOrder.length);
        int[] rightIn = Arrays.copyOfRange(inOrder,mid+1,inOrder.length);
        root.right=buildTree(rightPre,rightIn);

        return root;
    }
}
