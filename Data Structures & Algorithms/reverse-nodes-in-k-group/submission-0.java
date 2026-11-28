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
    public ListNode reverseLL (ListNode head) {
        if(head == null || head.next == null)    return head;
        ListNode temp = head;
        ListNode ans = new ListNode();
        while (temp != null) {
            ListNode last = ans.next;
            ListNode next = temp.next;
            temp.next = null;
            ans.next = temp;
            temp.next = last;
            temp = next;
        }
        return ans.next;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode ans = new ListNode();
        ListNode last = ans;
        int i = 1;
        ListNode temp = head;
        ListNode prev = ans;
        while(temp != null) {
            if (i % k == 0) {
                ListNode next = temp.next;
                temp.next = null;
                ListNode oldHead = head;
                head = reverseLL(head);
                prev.next = head;
                oldHead.next = next;
                prev = oldHead;
                head = next;
                temp = prev;
            }
            
            temp = temp.next;
            i++;
        }
        return ans.next;
    }
}
