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
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
      
}
//  Traverse node using dummy head for singly linked list
//  we need to store each at least the "current and previous" nodes
//   assign next pointer to current, go to next node
//   0 -> 1 -> 2 -> 3 -> null
//   0 -> 1 ->
//   dc  dn
//
//
//
//
//
//
//
//
//