/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals==null || intervals.size()==0) return 0;
        if(intervals.size()==1) return 1;
        int count=intervals.size();
        Collections.sort(intervals, (a,b)->Integer.compare(a.start, b.start));
        int n=intervals.size();
        List<int[]> list=new ArrayList<>();
        for(Interval i:intervals){
            int curr=i.start;
            boolean reused=false;
            for(int[] l:list){
                if(curr>=l[1]){
                    count--;
                    l[1]=i.end;
                    reused=true;
                    break;
                }
            }
            if(!reused){
                list.add(new int[]{i.start,i.end});
            }
        }
        return count;
    }
}
