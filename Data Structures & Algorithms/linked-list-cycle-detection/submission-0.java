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
    public boolean hasCycle(ListNode head) {
        //Intuition: use a set to keep track of seen values
        Set<Integer> seen = new HashSet<>();
        if (head == null){
            return false;
        }
        ListNode dummy = head;
        while(dummy.next !=null){
            if(seen.contains(dummy.val)){
                return true;
            } else{
                seen.add(dummy.val);
            }
            dummy = dummy.next;
        }
        return false;
        
    }
}
