class Solution(object):
    """
    :type candidates: List[int]
    :type target: int
    :rtype: List[List[int]]
    """
    def combinationSum(self, cans, t):
        if cans == None or len(cans) == 0:
            return
        res = []
        cans.sort()
        self.find(cans, t, 0, [], res)
        return res
        
    def find(self, cans, t, index, path, res):
        if t == 0:
            res.append(list(path))
            return
        for i in range(index, len(cans), 1):
            if cans[i] > t:
                break
            path.append(cans[i])
            self.find(cans, t-cans[i], i, path, res)
            del path[len(path)-1]