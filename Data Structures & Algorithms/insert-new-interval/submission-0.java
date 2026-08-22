class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        List<int[]> l=new ArrayList<>();
        int sn=newInterval[0];
        int en=newInterval[1];
        int i=0;
        while(i<n && intervals[i][1]<sn){
            l.add(intervals[i]);
            i++;
        }
        if(i<n) sn=Math.min(sn,intervals[i][0]);
        while(i<n && intervals[i][0]<=en){
            sn=Math.min(sn,intervals[i][0]);
            en=Math.max(en,intervals[i][1]);
            i++;
        }
        l.add(new int[]{sn, en});
        while(i<n){
            l.add(intervals[i]);
            i++;
        }
        return l.toArray(new int[l.size()][2]);
    }
}
