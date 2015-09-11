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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> listP = find(root, p);
        ArrayList<TreeNode> listQ = find(root, q);
        TreeNode node = null;
        int len = Math.min(listP.size(), listQ.size());
        for (int i=0; i<len; i++) {
            if (listP.get(i) != listQ.get(i)) break;
            node = listP.get(i);
        }
        return node;
    }
    
    private ArrayList<TreeNode> find(TreeNode root, TreeNode n) {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        while (true) {
            list.add(root);
            if (root.val == n.val) break;
            if (root.val < n.val) root = root.right;
            else                  root = root.left;
        }
        return list;
    }
}