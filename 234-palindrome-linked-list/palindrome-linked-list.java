import java.util.*;
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
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack();
        ListNode current = head;
        while(current != null){
            stack.push(current);
            current = current.next;
        }

        while(!stack.isEmpty()){
            if(head.val != stack.pop().val){
                return false;
            }
            head = head.next;
        }
        return true;
    }

}