# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    """
    :type root: TreeNode
    :rtype: TreeNode
    """
    def invertTree(self, root):
        if root == None:
            return root
        self.swap(root)
        return root
    
    def swap(self, root):
        tmp = root.left
        root.left = root.right
        root.right = tmp
        
        if root.left != None:
            self.swap(root.left)
        if root.right != None:
            self.swap(root.right)