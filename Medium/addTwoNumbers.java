// Problem: 2. Add Two Numbers
// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
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
        int sum = 0, value, carry = 0;
        ListNode dummy = new ListNode();                        // initialised a dummy node for keeping track of the linked list with the answer
        ListNode current = dummy;
        while(l1!=null && l2!=null){                            
            sum = l1.val + l2.val + carry;                      // Adds the values from l1 and l2 and the carry from the previous addition
            value = sum%10;                                     // The value to store in node
            carry = sum/10;                                     // The carry from the addition
            current.next = new ListNode(value);
            current = current.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode remaining = l1!=null?l1:l2!=null?l2:null;      // Find the list that is not empty
        while(remaining!=null){                                
            sum = remaining.val + carry;                        // Continue the addtion for the non empty list
            value = sum%10;
            carry = sum/10;
            current.next = new ListNode(value);
            current = current.next;
            remaining = remaining.next;
        }
        if(carry!=0){
            current.next = new ListNode(carry);
        }
        // Return the linked list that has the sum of the given numbers
        return dummy.next;                                   
    }
}
