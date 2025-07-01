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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ls1 = l1;
        ListNode ls2 = l2;

        ListNode result = new ListNode(0);
        ListNode ptr = result;

        int carry = 0;
        while (ls1 != null || ls2 != null) {
            int sum = 0 + carry;

            if (ls1 != null) {
                sum += ls1.val;
                ls1 = ls1.next;
            }
            if (ls2 != null) {
                sum += ls2.val;
                ls2 = ls2.next;
            }

            carry = sum / 10;
            ptr.next = new ListNode(sum % 10);
            ptr = ptr.next;
        }

        if (carry == 1) {
            ptr.next = new ListNode(1);
        }

        return result.next;
    }
}

/*
9 9 9 9 9 9 9
9 9 9 9
8 9 9 9 0 0 0 1*/