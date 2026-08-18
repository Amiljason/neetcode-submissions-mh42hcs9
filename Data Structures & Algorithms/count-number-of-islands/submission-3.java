class Solution {
    public boolean isSafe(char[][] grid, boolean[][] vis,int r, int c, int row, int col){
        return (r>=0 && r<row && c>=0 && c<col && grid[r][c]=='1' && vis[r][c]==false)?true:false;
    }
    public void dfs(char[][] grid, boolean[][] vis,int r, int c, int row, int col){
        if(grid[r][c]=='0') return ;
        vis[r][c]=true;
        for(int[] d:dir){
            int nr=r+d[0];
            int nc=c+d[1];
            if(isSafe(grid,vis,nr,nc,row,col)){
                dfs(grid,vis,nr,nc,row,col);
            }
        }
        return ;
    }
    int[][] dir=new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    public int numIslands(char[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
       int count=0;
       boolean[][] vis=new boolean[row][col];
       for(int i=0;i<row;i++){
        for(int j=0;j<col;j++){
            if(grid[i][j]=='1'){
                if(vis[i][j]==false){
                    count++;
                    dfs(grid,vis,i,j,row,col);
                }
            }
        }
       }
       return count;
    }
}
