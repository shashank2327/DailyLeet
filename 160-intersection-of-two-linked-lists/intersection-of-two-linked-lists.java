/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLen = 0;
        int bLen = 0;

        ListNode a = headA;
        ListNode b = headB;

        while(a != null) {
            aLen++;
            a = a.next;
        }
        while(b != null) {
            bLen++;
            b = b.next;
        }

        while (aLen > bLen) {
            headA = headA.next;
            aLen--;
        }

        while (bLen > aLen) {
            headB = headB.next;
            bLen--;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }


        return headA;
    }
}