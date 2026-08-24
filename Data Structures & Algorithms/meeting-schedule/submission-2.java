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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals==null||intervals.size()==0||intervals.size()==1) return true; 
        Collections.sort(intervals,(a,b)->Integer.compare(a.start,b.start));
        int n=intervals.size();
        int s=intervals.get(0).start;
        int e=intervals.get(0).end;
        for(int i=1;i<n;i++){
            if(e>intervals.get(i).start) return false;
            else e=intervals.get(i).end;
        }
        return true;
    }
}
