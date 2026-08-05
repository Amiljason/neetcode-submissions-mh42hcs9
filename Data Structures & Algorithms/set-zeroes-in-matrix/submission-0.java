class Solution {
    public void setZeroes(int[][] matrix) {
        Queue<int []> q=new LinkedList<>();
        int r=matrix.length;
        int c=matrix[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]==0){
                    q.add(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row=curr[0];
            int col=curr[1];
            for(int i=0;i<c;i++){
                matrix[row][i]=0;
            }
            for(int i=0;i<r;i++){
                matrix[i][col]=0;
            }
        }
    }
}
