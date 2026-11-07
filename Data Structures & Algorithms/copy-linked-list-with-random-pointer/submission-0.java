/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node newHead = new Node(0);
        Node temp = head;
        Node newTemp = newHead;
        while (temp!=null) {
            Node newNode = new Node(temp.val);
            newTemp.next = newNode;
            map.put(temp, newNode);
            temp = temp.next;
            newTemp = newTemp.next;
        }
        temp = head;
        newTemp = newHead.next;
        while (temp != null) {
            Node randomNode = temp.random;
            if (randomNode != null)
                newTemp.random = map.get(randomNode);
            temp = temp.next;
            newTemp = newTemp.next;
        }

        return newHead.next;
    }
}
