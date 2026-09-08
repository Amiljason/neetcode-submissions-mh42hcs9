class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=matrix.length;
        int col=matrix[0].length;
        int top=0,bot=row-1;
        while(top<=bot){
            int mid=(top+bot)/2;
            if(target>matrix[mid][col-1]){
                top=mid+1;
            }else if(target<matrix[mid][0]){
                bot=mid-1;
            }else{
                break;
            }
        }
        if(!(top<=bot)) return false;
        int mid=(top+bot)/2;
        int left=0,right=col-1;
        while(left<=right){
            int m=(left+right)/2;
            if(target>matrix[mid][m]){
                left=m+1;
            }else if(target<matrix[mid][m]){
                right=m-1;
            }else{
                return true;
            }
        }
        return false;
    }
}
