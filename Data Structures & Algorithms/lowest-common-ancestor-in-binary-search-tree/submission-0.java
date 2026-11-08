/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode lcaHelper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val > p.val && root.val < q.val)
            return root;
        if (root.val > p.val && root.val > q.val) {
            return lcaHelper(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lcaHelper(root.right, p, q);
        }
        return root;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==null || q == null) return null;
        return (p.val > q.val) ? lcaHelper(root, p, q) : lcaHelper(root, q, p);
    }
}
