class Solution(object):
    """
    :type s: int
    :type nums: List[int]
    :rtype: int
    """
    def minSubArrayLen(self, s, nums):
        if nums == None or len(nums) == 0 or s <= 0:
            return 0
            
        j, sum, count = 0, 0, len(nums)+1
        for i in range(len(nums)):
            while j < len(nums) and sum < s:
                sum += nums[j]
                j += 1
            if sum >= s:
                count = min(count, j-i)
            sum -= nums[i]
            
        if count == len(nums)+1:
            return 0
        else:
            return count