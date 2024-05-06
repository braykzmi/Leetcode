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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        return removeElements(null, head, val, head);
    }

    private ListNode removeElements(ListNode prev, ListNode current, int val, ListNode head){
        if(current == null){
            return head;
        }
        
        if(current.val == val){
            if(prev == null){
                head = head.next;
                return removeElements(null, head, val, head);
            }
            prev.next = current.next;
            return removeElements(prev, prev.next, val, head);
        }

        return removeElements(current, current.next, val, head);
    }
}