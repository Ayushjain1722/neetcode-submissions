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
    public ListNode reverseList(ListNode head) {
        ListNode last = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = null;
            ListNode tempLast = last;
            last = head;
            last.next = tempLast;
            if (temp == null) return head;
            head = temp;
        }
        return head;
    }
}
