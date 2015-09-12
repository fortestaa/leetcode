package medium;

import medium.LinkedListCycle.ListNode;

/**
 * 24 Swap Nodes in Pairs
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 */
public class Swap_Nodes_in_Pairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        ListNode p = head;
        while (p != null && p.next != null) {
            ListNode q = p.next, r = p.next.next;
            prev.next = q;
            q.next = p;
            p.next = r;
            prev = p;
            p = r;
        }
        return dummyHead.next;
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
