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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0,head);// we create a dummy head to return the new list
        ListNode left = dummy;// we intialize the left as dummy because reasons
        ListNode right = head;//we move the right pointer to the end of the list
        while (n > 0 && right != null){
            right = right.next;
            n--;
        }

        while(right != null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
}
