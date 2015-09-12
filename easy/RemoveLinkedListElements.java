package easy;

/**
 * 203	Remove Linked List Elements
 * https://leetcode.com/problems/remove-linked-list-elements/
 * 
 * Remove all elements from a linked list of integers that have value val.
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
    	ListNode dummyhead = new ListNode(-1);
    	dummyhead.next = head;
    	
    	ListNode prev = dummyhead;
    	ListNode curr = head;
    	while (curr != null) {
    		if (curr.val == val) {
    			ListNode next = curr.next;
    			prev.next = next;
    			curr = next;
    		} else {
    			prev = prev.next;
    			curr = curr.next;
    		}
    	}
    	return dummyhead.next;
    }
    
    public class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x)	{ val = x; }
    }
}