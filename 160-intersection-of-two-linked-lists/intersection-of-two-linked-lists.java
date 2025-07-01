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
        int aLen = 0; // length of list a
        int bLen = 0; // length of list b

        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != null) {
            aLen++;
            tempA = tempA.next;
        }

        while (tempB != null) {
            bLen++;
            tempB = tempB.next;
        }

        tempA = headA;
        tempB = headB;

        while (aLen > bLen) {
            aLen--;
            tempA = tempA.next;
        }

        while (bLen > aLen) {
            bLen--;
            tempB = tempB.next;
        }

        while (tempA != tempB) {
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return tempA;
    }
}