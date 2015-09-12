package medium;

/**
 * 141	Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
 * 
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)  return false;
        ListNode faster = head, slower = head;
        while (faster.next != null && faster.next.next != null) {
            slower = slower.next;
            faster = faster.next.next;
            if (slower == faster)   return true;
        }
        return false;
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
//http://www.cnblogs.com/springfor/p/3862102.html