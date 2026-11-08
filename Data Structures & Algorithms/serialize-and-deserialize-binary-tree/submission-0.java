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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder str = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp == null) {
                str.append(1001).append("#");
            } else {
                str.append(temp.val).append("#");
                q.add(temp.left);
                q.add(temp.right);
            }
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty())  return null;
    
        String vals[] = data.split("#");;

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        q.add(root);

        int index = 1;

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();

            if(Integer.parseInt(vals[index]) != 1001) {
                temp.left = new TreeNode(Integer.parseInt(vals[index]));
                q.add(temp.left);
            }

            index++;

            if (Integer.parseInt(vals[index]) != 1001) {
                temp.right = new TreeNode(Integer.parseInt(vals[index]));
                q.add(temp.right);
            }
            index++;
        }

        return root;
    }
}
