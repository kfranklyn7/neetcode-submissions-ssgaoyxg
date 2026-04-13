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
        ListNode prev = null; //since our first value will become the last value in the linked list, we point it to null
        ListNode curr = head;
        
        while (curr != null){// if we reach a null value ie what 3 points to, we stop and return the last value changed which is prev
            ListNode temp = curr.next;// we store the next node in the intial list
            curr.next = prev; // we point our current node to the next node in the current list to reverse it
            prev = curr; //we point our current node to the previous from the original
            curr = temp; // we set current as temp so that we can navigate through the initial list
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