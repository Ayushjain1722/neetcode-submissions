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
class X {
    boolean isBalanced;
    int height;
    public X(int height, boolean isBalanced) {
        this.height = height;
        this.isBalanced = isBalanced;
    }
}
class Solution {
    public X isBalancedHelper(TreeNode root) {
        if (root == null) return new X(0, true);

        X left = isBalancedHelper(root.left);
        X right = isBalancedHelper(root.right);
        boolean isRootBalanced = (left.isBalanced && right.isBalanced && (Math.abs(left.height - right.height) <= 1));
        return new X(1 + Math.max(left.height, right.height), isRootBalanced);
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return isBalancedHelper(root).isBalanced;
    }
}
