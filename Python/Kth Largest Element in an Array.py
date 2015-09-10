from heapq import heapify, heappushpop
class Solution(object):
    """
    :type nums: List[int]
    :type k: int
    :rtype: int
    """
    def findKthLargest(self, nums, k):
        heap = nums[0:k]
        heapify(heap)
        for i in range(k, len(nums), 1):
            if nums[i] > heap[0]:
                heappushpop(heap, nums[i])
        return heap[0]