class Solution {
    PriorityQueue<int[]> closest=new PriorityQueue<>((a,b)->Integer.compare(
        ((a[0]*a[0])+(a[1]*a[1])),((b[0]*b[0])+(b[1]*b[1]))
    ));
    public int[][] kClosest(int[][] points, int k) {
        int r=points.length;
        int c=points[0].length;
        for(int i=0;i<r;i++){
            closest.offer(new int[]{points[i][0],points[i][1]});
        }
        int[][] res=new int[k][2];
        int i=0;
        while(i!=k){
            int[] curr=closest.poll();
            res[i][0]=curr[0];
            res[i][1]=curr[1];
            i++;
        }
        return res;
    }
}
