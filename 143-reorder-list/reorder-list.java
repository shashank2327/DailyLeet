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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        // cut the list into two halves;
        // prev will be the tail of the 1st half;
        // slow will be the head of the 2nd half;
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode l1 = head;   //  first half head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }


        // Divide the LL in 2 part;
        prev.next = null;


        // head of the 2nd half;
        ListNode l2 = reverse(slow);

        // Merge both the list;
        merge(l1, l2);
    }


    public ListNode reverse(ListNode head) {
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

    public void merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode temp = dummyHead;
        while (l1 != null && l2 != null) {
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;

            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }

        if (l1 != null) {
            temp.next = l1;
        }
        if (l2 != null) {
            temp.next = l2;
        }

        dummyHead =  dummyHead.next;
    }
}