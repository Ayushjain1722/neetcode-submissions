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
    // public ListNode reverseLinkedList (ListNode head) {
    //     if (head == null || head.next == null) return head;
    //     ListNode temp = head.next;
    //     ListNode newHead = reverseLinkedList(head.next);
    //     temp.next = head;
    //     head.next = null;
    //     return newHead;
    // }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int size = 0;
        ListNode temp = head;
        while (temp!=null) {
            temp = temp.next;
            size++;
        }
        int removeIndex = size - n;
        if (removeIndex == 0) {
            return head.next;
        }
        temp = head;
        for (int i=0;i<removeIndex;i++) {
            if (i+1==removeIndex) {
                temp.next = temp.next==null? null: temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }
}
