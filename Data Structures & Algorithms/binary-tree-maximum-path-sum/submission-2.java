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
    int gMax = Integer.MIN_VALUE;
    public int Helper(TreeNode root) {
        if (root == null) return 0;
        int left = Helper(root.left);
        int right = Helper(root.right);

        int localMax = root.val + (left < 0? 0: left) + (right < 0? 0: right);
        gMax = Math.max(gMax, localMax);

        return root.val + Math.max(0, Math.max(left, right));
    }
    public int maxPathSum(TreeNode root) {
        Helper(root);
        return gMax;
    }
}
