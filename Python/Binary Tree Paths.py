# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    """
    :type root: TreeNode
    :rtype: List[str]
    """
    def binaryTreePaths(self, root):
        res = []
        self.printPaths(root, res, [])
        return res
        
    def printPaths(self, root, res, path):
        if root == None:
            return
        if root.left == None and root.right == None:
            path.append(str(root.val))
            res.append("".join(path))
            del path[len(path)-1]
            return
        
        path.append(str(root.val))
        path.append("->")
        
        self.printPaths(root.left, res, path)
        self.printPaths(root.right, res, path)
        
        del path[len(path)-2:len(path)]
        