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

        if (head == null || head.next == null) return true;

        ListNode prev = null; // always before slow ptr;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        ListNode firstHalf = head;
        ListNode secondHalf = reverseLinkedList(slow);


        ListNode firstPtr = firstHalf;
        ListNode secondPtr = secondHalf;

        while (firstPtr != null) {
            if (firstPtr.val != secondPtr.val) return false;
            firstPtr = firstPtr.next;
            secondPtr = secondPtr.next;
        }

        return true;
    }

    public ListNode reverseLinkedList(ListNode head) {
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