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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> list1 = new Stack<>();
        Stack<Integer> list2 = new Stack<>();
        Deque<Integer> list = new ArrayDeque<>();
        
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        // let's use a stack to keep the numbers in correct order, pop them from the stack into stringbuilder appending each new value until the stack is empty then return the sum
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        while(curr1 != null){
            list1.push(curr1.val);
            curr1 = curr1.next;
        }
        
        while(curr2 != null){
            list2.push(curr2.val);
            curr2 = curr2.next;
        }
        while (!list1.isEmpty()){
            num1.append(list1.pop());
        }
        while (!list2.isEmpty()){
            num2.append(list2.pop());
        }
        int num = Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString());
        ListNode result = new ListNode(0);
        ListNode next = result;
        while(num >= 0){
            System.out.println(num);
            System.out.println(num%10);
            if (num >= 11){
                 list.add(num%10);
            } else if (num == 10){
                list.add(0);
            } else {
                list.add(num);
                break;
            }
           
            num = num/10;
        }
   
        while(!list.isEmpty()){
            next.next = new ListNode(list.pop());
            next = next.next;
        }
        return result.next;
    }
}
