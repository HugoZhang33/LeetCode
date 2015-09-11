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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        find(root, res, new StringBuilder());
        return res;
    }
    
    private void find(TreeNode root, List<String> res, StringBuilder sb) {
        if (root == null)
            return;
        int len = sb.length();
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            res.add(sb.toString());
            sb.delete(len, sb.length());
            return;
        }
        sb.append(root.val);
        sb.append("->");
        
        find(root.left, res, sb);
        find(root.right, res, sb);
        sb.delete(len, sb.length());
    }
}