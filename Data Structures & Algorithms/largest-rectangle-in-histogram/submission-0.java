class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights==null||heights.length==0) return 0;
        if(heights.length==1) return heights[0];
        int maxArea=0,n=heights.length;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<=n;i++){
            int currHeight=(i==n)?0:heights[i];
            while(!stack.isEmpty() && currHeight<=heights[stack.peek()]){
                int height=heights[stack.pop()];
                int width=(stack.isEmpty())?i:i-stack.peek()-1;
                maxArea=Math.max(maxArea,height*width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
