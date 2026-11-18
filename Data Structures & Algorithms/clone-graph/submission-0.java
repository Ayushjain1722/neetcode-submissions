/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node Helper(Node node, HashMap<Node, Node> oldToNew) {
        if (node == null)   return node;
        if (oldToNew.containsKey(node)) return oldToNew.get(node);

        Node copy = new Node(node.val);
        oldToNew.put(node, copy);

        for(int i=0;i<node.neighbors.size();i++) {
            copy.neighbors.add(Helper(node.neighbors.get(i), oldToNew));
        }

        return copy;
    }
    public Node cloneGraph(Node node) {
        HashMap<Node, Node> oldToNew = new HashMap<>();
        return Helper(node, oldToNew);
    }
}