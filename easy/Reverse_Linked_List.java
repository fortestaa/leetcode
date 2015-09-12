package easy;

/**
 * 206	Reverse Linked List
 * https://leetcode.com/problems/reverse-linked-list/
 * Reverse a singly linked list.
 * click to show more hints.
 * Hint:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class Reverse_Linked_List {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)  return head;
        
        ListNode pre = head, cur = head.next;
        pre.next = null;
        ListNode next = null;
        
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseList0(ListNode head) {
    	if (head == null || head.next == null)	return head;
    	
    	ListNode dummy = head;
    	ListNode prev = null;
    	ListNode temp = null;
    	while (dummy.next != null) {
    		prev = head;
    		head = dummy.next;
    		temp = head.next;
    		head.next = prev;
    		dummy.next = temp;
    	}
    	
    	return head;
    }
    //http://www.cnblogs.com/TinyBobo/p/4515450.html
    
    class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x)	{ val = x; }
    }
}