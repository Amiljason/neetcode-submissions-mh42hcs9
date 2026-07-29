class Solution {
    public int maxArea(int[] heights) {
       int left=0,right=heights.length-1;
       int Area=Integer.MIN_VALUE;
       while(left<right){
        int length=right-left;
        int breadth=Math.min(heights[left],heights[right]);
        int product=length*breadth;
        Area=Math.max(Area, product);
        if(heights[left]<heights[right]) left++;
        else right--;
       }
       return Area;
    }
}
