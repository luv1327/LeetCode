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
        ListNode ans = new ListNode(0);
        ListNode temp = ans;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->a.val - b.val);
        for(ListNode singleNode : lists){
            if(singleNode != null){
                minHeap.add(singleNode);
            }
        }

        while(!minHeap.isEmpty()){
            ListNode minNode = minHeap.poll();
            temp.next = minNode;
            temp = temp.next;
            if(minNode.next != null){
                minHeap.add(minNode.next);
            }
        }

        return ans.next;
    }
}