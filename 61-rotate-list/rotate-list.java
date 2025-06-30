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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        int len = 0; // length of the list;
        ListNode temp = head;
        ListNode prevTemp = null;
        while (temp != null) {
            len++;
            prevTemp = temp;
            temp = temp.next;
        }
        // After this while loop, temp is pointing to last point.

        if (k % len == 0) return head;

        int pointOfRotation = len - (k % len);
        int idx = 0;

        ListNode nextHead = head;
        ListNode prev = null;
        while (idx < pointOfRotation) {
            prev = nextHead;
            nextHead = nextHead.next;
            idx++;
        }

        prev.next = null;

        prevTemp.next = head;
        
        return nextHead;
    }
}