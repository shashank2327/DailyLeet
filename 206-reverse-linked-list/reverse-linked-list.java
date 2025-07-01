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
        if (head == null) return null;
        ListNode prev = null;
        ListNode curr = head;
        ListNode ahead = head.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = ahead;
            if (curr == null) break;
            ahead = ahead.next;
        }

        return prev;
    }
}

// 1 -> 2 -> 3 -> 4 -> 5;  // prev = 1 // curr = 1 // ahead = 2;