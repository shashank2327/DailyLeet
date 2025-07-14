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
    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        int val = 0;
        temp = head;
        while (temp != null) {
            int nodeVal = temp.val;
            if (temp.val == 1) {
                val += Math.pow(2, len - 1);
            }
            len--;
            temp = temp.next;
        }

        return val;
    }
}