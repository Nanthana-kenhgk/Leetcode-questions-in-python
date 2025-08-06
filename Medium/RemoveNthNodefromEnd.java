// Problem: 19. Remove nth node from the end of a list
//Given the head of a linked list, remove the nth node from the end of the list and return its head.
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
    ListNode slow = head;
		ListNode fast = head;
		for(int i=0;i<n;i++) {         // Move fast pointer n steps ahead of slow pointer
			if(fast!=null) {          
				fast = fast.next;
			}  
		}                    
		if(fast==null) {              // If fast becomes null, we need to remove the head node
			head = head.next;
			if(head==null) {
				return null;
			}
			else {
				return head;
			}
		}
		ListNode temp = null;        // Temporary pointer to keep track of the previous node of slow
		while(fast!=null) {          // Move slow and fast pointers one node at a time
			temp = slow;
			slow = slow.next; 
			fast = fast.next;
		}
		temp.next = temp.next.next;   // Skip the nth node from the end, thus deleting it from the list
    // return head
		return head;
    }
}
