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
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = new ListNode(-1);
        ListNode oddHead = odd;
        ListNode even = new ListNode(-1);
        ListNode evenHead = even;

        boolean flag = true; // true means I am on the odd Index.

        ListNode temp = head;
        while (temp != null) {
            int val = temp.val;
            if (flag) {
                odd.next = new ListNode(val);
                odd = odd.next;
            } else {
                even.next = new ListNode(val);
                even = even.next;
            }
            flag = !flag;
            temp = temp.next;
        }

        odd.next = evenHead.next;

        return oddHead.next;
    }
}