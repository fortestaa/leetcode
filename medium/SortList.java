package medium;

/**
 * 148	Sort List
 * https://leetcode.com/problems/sort-list/
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)  return head;
        ListNode slow = head, fast = head, firsthalf = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondhalf = slow.next;
        slow.next = null;
        
        ListNode leftlist = null, rightlist = null;
        if (firsthalf != secondhalf) {
            leftlist = sortList(firsthalf);
            rightlist = sortList(secondhalf);
        }
        return mergeTwoLists(leftlist, rightlist);
    }
    
    public ListNode mergeTwoLists(ListNode leftlist, ListNode rightlist) {
        if (rightlist == null)  return leftlist;
        if (leftlist == null)   return rightlist;
        
        ListNode fakehead = new ListNode(-1);
        ListNode ptr = fakehead;
        while (leftlist != null && rightlist != null) {
            if (leftlist.val < rightlist.val) {
                ptr.next = leftlist;
                ptr = ptr.next;
                leftlist = leftlist.next;
            } else {
                ptr.next = rightlist;
                ptr = ptr.next;
                rightlist = rightlist.next;
            }
        }
        
        if (rightlist != null)  ptr.next = rightlist;
        if (leftlist != null)   ptr.next = leftlist;
        return fakehead.next;
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
//http://www.cnblogs.com/springfor/p/3869372.html