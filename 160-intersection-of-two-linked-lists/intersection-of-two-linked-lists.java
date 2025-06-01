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
        ListNode ptrA = headA;
        ListNode ptrB = headB;

        // If the ptrA == ptrB --> there is an intersection;

        Set<ListNode> set = new HashSet<>();

        while (ptrA != null) {
            set.add(ptrA);
            ptrA = ptrA.next;
        }

        while (ptrB != null) {
            if (set.contains(ptrB)) {
                return ptrB;
            }

            ptrB = ptrB.next;
        }

        return null;
    }
}