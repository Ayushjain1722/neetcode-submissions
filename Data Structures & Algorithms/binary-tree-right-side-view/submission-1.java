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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return ans;
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0;i<size;i++) {
                TreeNode ele = q.poll();
                if (ele.left != null) q.add(ele.left);
                if (ele.right != null) q.add(ele.right);

                if (i == size - 1) {
                    ans.add(ele.val);
                }
            }
        }

        return ans;
    }
}
