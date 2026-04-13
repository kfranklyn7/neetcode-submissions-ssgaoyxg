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
    public void reorderList(ListNode head) {
        //find the middle by using fast and slow pointers
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse second half of the list
        ListNode second = slow.next;
        ListNode prev = slow.next = null;
        while (second != null){
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }
        second = prev;
        ListNode first = head;
        while (second != null){
            ListNode temp = first.next, temp2 = second.next;
            first.next = second;
            second.next = temp;
            first = temp;
            second = temp2;
        }

    }
}
// reorder in the form [0, n-1, 1, n-2, 2, n-3, ...]
// pair the 2nd to last with the 2nd
// 3rd to last with the third etc 
//
// use slow and fast pointer strategy
//
//
//
//