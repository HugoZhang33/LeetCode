# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    """
    :type intervals: List[Interval]
    :rtype: List[Interval]
    """
    def merge(self, intervals):
        if intervals == None or len(intervals) <= 1:
            return intervals
    
        intervals = sorted(intervals, key=lambda interval : interval.start)
        
        result = []
        interval = intervals[0]
        for i in range(1, len(intervals), 1):
            cur = intervals[i]
            if cur.start <= interval.end:
                interval.end = max(interval.end, cur.end)
            else:
                result.append(interval)
                interval = cur
                        
                        
        result.append(interval)
        return result