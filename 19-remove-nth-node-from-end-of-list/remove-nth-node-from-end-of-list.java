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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        int startPoint = len - n;
        if (startPoint == 0) {
            return head.next;
        }

        temp = head;
        ListNode prev = null;
        while (startPoint != 0) {
            startPoint--;
            prev = temp;
            temp = temp.next;
        }

        prev.next = temp.next;

        return head;
    }
}