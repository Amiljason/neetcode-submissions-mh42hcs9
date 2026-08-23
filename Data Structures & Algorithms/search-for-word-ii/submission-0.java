public class TrieNode{
    Map<Character, TrieNode> children=new HashMap<>();
    boolean endOfWord=false;

    public void addString(String word){
        TrieNode curr=this;
        for(char c:word.toCharArray()){
            if(curr.children.get(c)==null){
                curr.children.put(c,new TrieNode());
                curr=curr.children.get(c);
            }
            else curr=curr.children.get(c);
        }
        curr.endOfWord=true;
    }
}
class Solution {
    HashSet<String> res;
    boolean[][] vis;

    public void dfs(char[][] board, int r, int c, TrieNode node, String word, int row, int col){
        if(r<0||c<0||r>=row||c>=col||vis[r][c]||!node.children.containsKey(board[r][c])) return ;
        vis[r][c]=true;
        node=node.children.get(board[r][c]);
        word+=board[r][c];
        if(node.endOfWord) res.add(word);
        dfs(board,r-1,c,node,word,row,col);
        dfs(board,r+1,c,node,word,row,col);
        dfs(board,r,c-1,node,word,row,col);
        dfs(board,r,c+1,node,word,row,col);
        vis[r][c]=false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root=new TrieNode();
        for(String word:words){
            root.addString(word);
        }
        int row=board.length;
        int col=board[0].length;
        res=new HashSet<>();
        vis=new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                dfs(board,i,j,root,"",row,col);
            }
        }
        return new ArrayList<>(res);
    }
}
