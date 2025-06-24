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

 class Pair {
    int headValue;
    ListNode node;

    public Pair(int headValue, ListNode node) {
        this.headValue = headValue;
        this.node = node;
    }
 }


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> p1.headValue - p2.headValue);
        for (ListNode node : lists) {
            if (node == null) continue;
            minHeap.offer(new Pair(node.val, node));
        }

        ListNode res = new ListNode(-1); // dummy value -1;
        ListNode temp = res; // temporary Node for traversal;

        while (!minHeap.isEmpty()) {
            Pair token = minHeap.poll();
            ListNode node = token.node;
            int headVal = token.headValue;
            temp.next = new ListNode(headVal);
            temp = temp.next;


            if (node.next != null) {
                node = node.next;
                minHeap.offer(new Pair(node.val, node));
            }
        }


        return res.next;
    }
}