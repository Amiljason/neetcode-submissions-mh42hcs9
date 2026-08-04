class Solution {
    int[][] dir ={{-1,0},{1,0},{0,-1},{0,1}};
    public boolean dfs(char[][] board,boolean[][] vis,char[] letters,int row, int col, int k){
        if((row<0 || row>=board.length) || (col<0 || col>=board[0].length)) return false;
        if(vis[row][col]) return false;
        if(board[row][col]!=letters[k]) return false;
        if(k==letters.length-1) return true;
        vis[row][col]=true;
        for(int[] d:dir){
            int nr=row+d[0];
            int nc=col+d[1];
            if(dfs(board,vis,letters,nr,nc,k+1)){
                return true;
            }
        }
        vis[row][col]=false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int row=board.length;
        int col=board[0].length;
        int k=0;
        boolean[][] vis = new boolean[row][col];
        char[] letters=word.toCharArray();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]==letters[0]){
                    if(dfs(board,vis,letters,i,j,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
