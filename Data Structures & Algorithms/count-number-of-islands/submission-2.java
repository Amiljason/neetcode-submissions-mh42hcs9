class Solution {
    int[][] dir=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public boolean isSafe(char[][] grid,boolean[][] vis,int i,int j,int row,int col){
        return (i>=0 && i<row && j>=0 && j<col && grid[i][j]=='1' && vis[i][j]==false)?true:false;
    }
    public void dfs(char[][] grid,boolean[][] vis,int i,int j,int row,int col){
        if(grid[i][j]=='0') return ;
        vis[i][j]=true;
        for(int[] d:dir){
            int ni=i+d[0];
            int nj=j+d[1];
            if(isSafe(grid,vis,ni,nj,row,col)) dfs(grid, vis,ni,nj,row,col);
        }
    } 
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
                        dfs(grid, vis, i, j , row, col);
                    }
                }
            }
        }
        return count;
    }
}
