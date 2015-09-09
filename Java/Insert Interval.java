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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null || intervals == null)
            return intervals;
            
        List<Interval> result = new ArrayList<Interval>();
        int pos = 0;
        
        for (Interval iv : intervals) {
            if (iv.end < newInterval.start) {
                result.add(iv);
                pos++;
            } else if (iv.start > newInterval.end) {
                result.add(iv);
            } else {
                newInterval.start = Math.min(newInterval.start, iv.start);
                newInterval.end   = Math.max(newInterval.end, iv.end);
            }
        }
        
        result.add(pos, newInterval);
        
        return result;
    }
}