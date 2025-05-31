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
    public ListNode deleteMiddle(ListNode head) {
        ListNode temp = new ListNode(-1);
        temp.next = head;

        ListNode slow = temp.next;
        ListNode fast = temp.next;
        ListNode prev = temp;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            prev = prev.next;
        }

        prev.next = slow.next;

        return temp.next;
    }
}