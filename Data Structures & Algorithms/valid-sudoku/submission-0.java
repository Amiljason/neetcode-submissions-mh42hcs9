class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set=new HashSet<>();
        int r=board.length;
        int c=board[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(board[i][j]=='.') continue;
                else{
                    String row=board[i][j]+" in row "+i;
                    String col=board[i][j]+" in col "+j;
                    String box=board[i][j]+" in box "+i/3+","+j/3;
                    if(set.contains(row)||set.contains(col)||set.contains(box)) return false;
                    else{
                        set.add(row);
                        set.add(col);
                        set.add(box);

                    }
                }
            }
        }
        return true;
    }
}
