package easy;

/**
 * 234	Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/
 * 
 * Given a singly linked list, determine if it is a palindrome.
 * Follow up: Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)  return true;
        
        ListNode middle = partition(head);
        middle = reverse(middle);
        
        while (head != null && middle != null) {
            if (head.val != middle.val) return false;
            head = head.next;
            middle = middle.next;
        }
        return true;
    }
    
    private ListNode partition(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        return fast;
    }
    
    private ListNode reverse(ListNode head) {
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
    
    public static class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x)	{ val = x; }
    }
    
    public static void main(String[] args) {
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(1);
    	ListNode n3 = new ListNode(2);
    	ListNode n4 = new ListNode(1);
    	n1.next = n2;
    	n2.next = n3;
    	n3.next = n4;
    	PalindromeLinkedList p = new PalindromeLinkedList();
    	System.out.println(p.isPalindrome(n1));
    }
}
// http://www.cnblogs.com/ganganloveu/p/4635328.html