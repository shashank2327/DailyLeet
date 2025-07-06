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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode firstHalf = head;
        ListNode secondHalf = head;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        secondHalf = slow.next;
        slow.next = null;

        ListNode reverseSecond = reverseLinkedList(secondHalf);

        ListNode temp1 = firstHalf;
        ListNode temp2 = reverseSecond;

        while (temp1 != null && temp2 != null) {
            if (temp1.val != temp2.val) {
                return false;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return true;
    }

    private ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode ahead = head.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = ahead;
            if (curr == null) {
                break;
            }
            ahead = ahead.next;
        }

        return prev;
    }
}
