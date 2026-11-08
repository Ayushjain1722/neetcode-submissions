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
    public TreeNode buildTreeHelper(int[] preorder, int l, int r, int sI, HashMap<Integer, Integer> map) {
        if (l > r) return null;
        int currRoot = preorder[sI];
        TreeNode root = new TreeNode(currRoot);
        int mid = map.get(root.val);
        root.left = buildTreeHelper(preorder, l, mid-1,sI+1, map);
        root.right = buildTreeHelper(preorder, mid+1, r, sI+(mid-l)+1, map);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i<inorder.length;i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, inorder.length-1, 0, map);
    }
}
