# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    """
    :type intervals: List[Interval]
    :type newInterval: Interval
    :rtype: List[Interval]
    """
    def insert(self, intervals, newInterval):
        if intervals == None or newInterval == None:
            return intervals
            
        result = []
        pos    = 0
        
        for iv in intervals:
            if iv.end < newInterval.start:
                result.append(iv)
                pos += 1
            elif iv.start > newInterval.end:
                result.append(iv)
            else:
                newInterval.start = min(newInterval.start, iv.start)
                newInterval.end   = max(newInterval.end, iv.end)
                
        result.insert(pos, newInterval)
        
        return result
                