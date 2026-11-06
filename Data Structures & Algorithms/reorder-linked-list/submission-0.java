/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    public ListNode reverseLinkedList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode temp = head.next;
        ListNode newHead = reverseLinkedList(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = slow.next;
        slow.next = null;

        secondHalf = reverseLinkedList(secondHalf);

        ListNode temp1 = head;
        ListNode ans = new ListNode();
        ListNode temp = ans;
        while(temp!=null && secondHalf!=null) {
            temp.next = temp1;
            temp = temp.next;
            temp1 = temp1.next;

            temp.next = secondHalf;
            temp = temp.next;
            secondHalf = secondHalf.next;
        }   
        if (temp1 != null) temp.next = temp1;
        if (secondHalf != null) temp.next = secondHalf;

        ans = ans.next;
    }
}
