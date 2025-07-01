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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevLast = null;

        while (temp != null) {
            ListNode kThNode = getKthNode(temp, k);

            // not a complete group
            if (kThNode == null) {
                // if there was a prevLast group;
                // link the prev last to current node;
                if (prevLast != null) {
                    prevLast.next = temp;
                }
                break;
            }

            ListNode nextNode = kThNode.next;

            // break the group;
            kThNode.next = null;

            reverseLinkedList(temp);

            if (temp == head) {
                head = kThNode;
            } else {
                prevLast.next = kThNode;
            }

            prevLast = temp;

            temp = nextNode;
        }

        return head;
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

    public ListNode getKthNode(ListNode temp, int k) {
        k--; // counting the start point;
        while (temp != null && k > 0) {
            temp = temp.next;
            k--;
        }
        return temp;
    }
}