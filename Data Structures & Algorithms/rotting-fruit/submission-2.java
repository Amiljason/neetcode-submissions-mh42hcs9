class Solution {
    public boolean isSafe(int[][] grid, int r, int c, int nr, int nc){
        return (nr>=0 && nr<r && nc>=0 && nc<c && grid[nr][nc]==1)?true:false;     
    }
    public int orangesRotting(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int timeElapsed=0;
        int[][] dir=new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
        while(!q.isEmpty()){
            boolean flag=false;
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            for(int[] d:dir){
                int nr = r+d[0];
                int nc = c+d[1];
                if(isSafe(grid, row, col, nr, nc)){
                    grid[nr][nc]=2;
                    q.offer(new int[]{nr,nc});
                    flag=true;
                }
            }
            }
            if(flag) timeElapsed++;
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 1) return -1;

            }
        }
        return timeElapsed;
    }
}
