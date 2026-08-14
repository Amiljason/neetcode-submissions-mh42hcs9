class Solution {
    int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public boolean isValid(int nr, int nc , int r, int c){
        return (nr>=0 && nr<r && nc>=0 && nc<c)?true:false;
    }
    public void bfs(Queue<int[]> height, boolean[][] reach, int r, int c, int[][] heights){
        while(!height.isEmpty()){
            int[] curr = height.poll();
            for(int[] d:dir){
                int nr=curr[0]+d[0];
                int nc=curr[1]+d[1];
                if(isValid(nr,nc,r,c) && !reach[nr][nc] && heights[nr][nc]>=heights[curr[0]][curr[1]]){
                reach[nr][nc]=true;
                height.offer(new int[]{nr, nc});
                } 
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row=heights.length;
        int col=heights[0].length;
        boolean[][] reachP=new boolean[row][col];
        boolean[][] reachA=new boolean[row][col];
        Queue<int[]> heightP=new LinkedList<>();
        Queue<int[]> heightA=new LinkedList<>();
        //top-bottom;
        for(int i=0;i<col;i++){
            heightP.offer(new int[]{0,i});
            reachP[0][i]=true;
            heightA.offer(new int[]{row-1,i});
            reachA[row-1][i]=true;
        }
        //left-right;
        for(int i=0;i<row;i++){
            heightP.offer(new int[]{i,0});
            reachP[i][0]=true;
            heightA.offer(new int[]{i,col-1});
            reachA[i][col-1]=true;
        }
        bfs(heightP,reachP,row,col,heights);
        bfs(heightA,reachA,row,col,heights);
        List<List<Integer>> islands=new ArrayList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(reachP[i][j]==true && reachA[i][j]==true) islands.add(Arrays.asList(i,j));
            }
        }
        return islands;
    }
}
