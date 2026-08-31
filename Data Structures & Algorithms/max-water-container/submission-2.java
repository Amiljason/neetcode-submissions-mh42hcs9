class Solution {
    public int maxArea(int[] heights) {
        int maxArea=Integer.MIN_VALUE;
        int n=heights.length;
        int l=0,r=n-1;
        while(l<r){
            int len=Math.min(heights[l],heights[r]);
            int brd=r-l;
            maxArea=Math.max(maxArea,len*brd);
            if(heights[l]>heights[r]) r--;
            else l++;
        }
        return maxArea;
    }
}
