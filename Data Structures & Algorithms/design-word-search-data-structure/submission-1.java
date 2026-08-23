public class TrieNode{
    TrieNode[] children=new TrieNode[26];
    boolean endOfWord=false;
}
class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root=new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr=root;
        for(char c:word.toCharArray()){
            int index=c-'a';
            if(curr.children[index]==null){
                curr.children[index]=new TrieNode();
                curr=curr.children[index];
            }
            else curr=curr.children[index];
        }
        curr.endOfWord=true;
    }

    public boolean dfs(TrieNode root, int index, String word){
        TrieNode curr=root;
        for(int i=index;i<word.length();i++){
            char c=word.charAt(i);
            if(c=='.'){
                for(TrieNode child:curr.children){
                    if(child!=null && dfs(child,i+1,word)) return true;
                }
                return false;
            }else{
                int idx=c-'a';
                if(curr.children[idx]==null) return false;
                else curr=curr.children[idx];
            }
        }
        return curr.endOfWord;
    }

    public boolean search(String word) {
        return dfs(root,0,word);
    }   
}
