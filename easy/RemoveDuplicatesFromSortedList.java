// Problem: 83. Remove duplicates from sorted list
// Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {           // If the current node has the same value as the next node then the next node is skipped
                current.next = current.next.next;
            } else {
                current = current.next;                     // If the values are different then current is moved to the next node
            }
        }
        // the head of the linked list is returned
        return head;
    }
}
