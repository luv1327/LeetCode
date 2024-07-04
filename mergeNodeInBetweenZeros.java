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
    public ListNode mergeNodes(ListNode head) {
        return modifyList(head.next);
    }

    public ListNode modifyList(ListNode head){
        int runningSum = 0;
        ListNode temp = head;
        ListNode dummy = new ListNode(0);
        ListNode p1 = dummy;
        while(temp != null){
            if(temp.val == 0){
                temp.val = runningSum;
                p1.next = temp;
                p1 = p1.next;
                runningSum = 0;
            }else{
                runningSum += temp.val;
            }
            temp = temp.next;
        }
        return dummy.next;
    }
}