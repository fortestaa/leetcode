package medium;

/**
 * 142	Linked List Cycle II
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * 
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Note: Do not modify the linked list.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)  return null;
        
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null)  return null;
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)   break;
        }
        
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    
    /**
     * Definition for singly-linked list.
     */
     class ListNode {
    	 int val;
    	 ListNode next;
    	 ListNode(int x) {
    		 val = x;
    		 next = null;
    	 }
     }
}
//http://www.cnblogs.com/springfor/p/3862125.html