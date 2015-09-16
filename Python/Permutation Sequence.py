class Solution(object):
    """
    :type n: int
    :type k: int
    :rtype: str
    """
    def getPermutation(self, n, k):
        nums = []
        lens = []
        lens.append(1)
        for i in range(1, n+1, 1):
            nums.append(i)
            lens.append(lens[i-1]*i)
        
        k -= 1
        res = []
        
        while n > 1:
            len = lens[n-1]
            num = nums[k/len]
            res.append(str(num))
            del nums[k/len]
            n -= 1
            k %= len
        
        res.append(str(nums[0]))
        return "".join(res)
        