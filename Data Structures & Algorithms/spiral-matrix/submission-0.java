class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> sp=new ArrayList<>();
        int r=matrix.length;
        int c=matrix[0].length;
        int top=0,bottom=r-1,left=0,right=c-1;
        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
                sp.add(matrix[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                sp.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    sp.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    sp.add(matrix[i][left]);
                }
                left++;
            }
        }
        return sp;
    }
}
