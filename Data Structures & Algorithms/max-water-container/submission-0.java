class Solution {
    public int maxArea(int[] heights) {
        int Area=Integer.MIN_VALUE;
        int n=heights.length;
        int l=0, b=0, i=0, j=n-1, prod=1;
        while(j>i){
            l=j-i;
            b=Math.min(heights[j],heights[i]);
            prod=l*b;
            Area=Math.max(Area, prod);
            if(heights[j]<heights[i])j--;
            else i++;
        }
        return Area;
    }
}
