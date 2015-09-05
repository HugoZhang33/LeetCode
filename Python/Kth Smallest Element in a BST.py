# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
    node = None
    def kthSmallest(self, root, k):
        self.scan(root, k)
        return Solution.node.val
    
    def scan(self, root, k):
        if root == None:
            return k;
        
        k = self.scan(root.left, k)
        if k == -1:
            return k;
        
        k -= 1
        if k == 0:
            Solution.node = root
            k -= 1
            return k

        return self.scan(root.right, k)