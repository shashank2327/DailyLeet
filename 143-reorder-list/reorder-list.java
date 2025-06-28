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
        if (head ==  null || head.next == null) return;

        // cut the list into two halves;
        // prev will be the tail of 1st half;
        // slow will be the head of 2nd half;
        ListNode prev = null, slow = head, fast = head, l1 = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        // Reverse the second half
        ListNode l2 = reverse(slow);

        // Merge both of them;
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
            if (curr == null) break;
            ahead = ahead.next;
        } 

        return prev;
    }

    void merge(ListNode l1, ListNode l2) {
      while (l1 != null) {
        ListNode n1 = l1.next, n2 = l2.next;
        l1.next = l2;
        
        if (n1 == null)
          break;
            
        l2.next = n1;
        l1 = n1;
        l2 = n2;
      }
    }
}