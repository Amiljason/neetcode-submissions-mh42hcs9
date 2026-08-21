class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0) return new int[0][0];
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        List<List<Integer>> list=new ArrayList<>();
        list.add(Arrays.asList(intervals[0][0],intervals[0][1]));
        for(int i=1;i<intervals.length;i++){
            List<Integer> curr=list.get(list.size()-1);
            int start=curr.get(0);
            int end=curr.get(1);
            int s=intervals[i][0];
            int e=intervals[i][1];
            if(s<=end){
                curr.set(1,Math.max(e,end));
            }else{
                list.add(Arrays.asList(s,e));
            }
        }
        int row=list.size();
        int col=list.get(0).size();
        int[][] arr=new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                arr[i][j]=list.get(i).get(j);
            }
        }
        return arr;
    }
}
