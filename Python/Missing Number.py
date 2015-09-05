class Solution(object):
    """
    :type nums: List[int]
    :rtype: int
    """
    def missingNumber(self, nums):
        if nums == None or len(nums) == 0:
            return 0
        
        sum1 = 0
        sum2 = 0
        maxNum  = 0
        
        for i in range(len(nums)):
            maxNum = max(maxNum, nums[i])
            sum2 += nums[i]
        
        sum1 = maxNum*(maxNum+1)/2
        
        if sum1 > sum2:
            return sum1 - sum2
        elif len(nums) > maxNum:
            return len(nums)
        else:
            return 0