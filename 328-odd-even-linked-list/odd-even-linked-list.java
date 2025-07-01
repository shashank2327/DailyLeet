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
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode first = head;
        ListNode second = head.next;
        ListNode secondHead = second;
        int parity = 0;
        while (second.next != null) {
            first.next = second.next;
            parity++;
            first = second;
            second = first.next;
        }
        if (parity % 2 == 0) {
            first.next = secondHead;
        } else {
            first.next = null;
            second.next = secondHead;
        }
        return head;
    }
}