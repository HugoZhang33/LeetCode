/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private TreeNode node = null;
    
    public int kthSmallest(TreeNode root, int k) {
        scan(root, k);
        return node.val;
    }
    
    private int scan(TreeNode root, int k) {
        if (root == null) {
            return k;
        }
        k = scan(root.left, k);
        if (k == -1)
            return k;
        
        k -= 1;
        if (k == 0) {
            node = root;
            k -= 1;
            return k;
        }
        
        return scan(root.right, k);
    }
}