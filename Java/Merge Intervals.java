/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0)
            return result;
        
        Collections.sort(intervals, new sortByStart());
        
        Interval i = intervals.get(0);
        for (int j=1; j<intervals.size(); j++) {
            Interval next = intervals.get(j);
            if (next.start<=i.end) {
                i.end = Math.max(next.end, i.end);
            } else {
                result.add(i);
                i = next;
            }
        }
        result.add(i);
        return result;
    }
    
    class sortByStart implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }
}