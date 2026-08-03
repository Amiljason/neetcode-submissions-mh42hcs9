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

public class Codec {
    public int preIdx=0;

    private void dfs(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("#,");
            return ;
        }
        else{
            sb.append(root.val).append(",");
            dfs(root.left,sb);
            dfs(root.right,sb);
        }
        return ;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();     
        dfs(root,sb);
        return sb.toString();
    }

    private TreeNode buildTree(String data) {
        int start = preIdx;
        while (data.charAt(preIdx) != ',') {
            preIdx++;
        }
        String currToken = data.substring(start, preIdx);
        preIdx++; // comma
        if (currToken.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(currToken));
        node.left = buildTree(data);
        node.right = buildTree(data);
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        preIdx = 0; 
        return buildTree(data);
    }
}
