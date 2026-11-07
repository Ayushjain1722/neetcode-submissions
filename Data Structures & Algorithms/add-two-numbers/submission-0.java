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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode temp1 = l1;
       ListNode temp2 = l2;
       ListNode head = new ListNode(0);
       ListNode temp = head;
       int carry = 0;
       while (temp1!=null && temp2!=null) {
        int sum = temp1.val + temp2.val + carry;
        if (sum >= 10) {
            carry = 1;
            sum -= 10;
        } else {
            carry = 0;
        }
        temp.next = new ListNode(sum);
        temp = temp.next;
        temp2 = temp2.next;
        temp1 = temp1.next;
       } 

       while (temp1 != null) {
        int sum = temp1.val + carry;
        if (sum >= 10) {
            sum -= 10;
            carry = 1;
        } else {
            carry = 0;
        }
        temp.next = new ListNode(sum);
        temp1 = temp1.next;
        temp = temp.next;
       }

       while (temp2 != null) {
        int sum = temp2.val + carry;
        if (sum >= 10) {
            sum -= 10;
            carry = 1;
        } else {
            carry = 0;
        }
        temp.next = new ListNode(sum);
        temp2 = temp2.next;
        temp = temp.next;
       }
        if (carry == 1) {
            temp.next = new ListNode(1);
        }
       return head.next;
    }
}
