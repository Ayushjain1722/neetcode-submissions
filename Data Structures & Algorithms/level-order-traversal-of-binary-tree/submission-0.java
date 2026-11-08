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
    public void levelOrderHelper(TreeNode root, HashMap<Integer, List<Integer>> map, int d) {
        if (root == null) return;
        if (map.containsKey(d)) {
            map.get(d).add(root.val);
        } else {
            map.put(d, new ArrayList<>());
            map.get(d).add(root.val);
        }
        levelOrderHelper(root.left, map, d + 1);
        levelOrderHelper(root.right, map, d + 1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        levelOrderHelper(root, map, 0);
        List<List<Integer>> ans = new ArrayList<>();
        for(Integer i: map.keySet()) {
            ans.add(map.get(i));
        }
        return ans;
    }
}
