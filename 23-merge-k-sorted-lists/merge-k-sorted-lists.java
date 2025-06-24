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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = lists.length;
        for (int i = 0; i < n; i++) {
            ListNode head = lists[i];
            ListNode temp = head;
            while (temp != null) {
                pq.add(temp.val);
                temp = temp.next;
            }
        }

        ListNode result = new ListNode(-1);
        ListNode temp = result;

        while (!pq.isEmpty()) {
            temp.next = new ListNode(pq.remove());
            temp = temp.next;
        }

        result = result.next;
        return result;
    }
}