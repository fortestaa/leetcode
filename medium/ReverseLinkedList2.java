package medium;

/**
 * 92	Reverse Linked List II
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * 
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
 */
public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)   return null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preNode = dummy;
        int i = 1;
        while (preNode.next != null && i < m) {
            preNode = preNode.next;
            i++;
        }
        if (i < m)  return head;
        ListNode mNode = preNode.next;
        ListNode cur = mNode.next;
        while (cur != null && i < n) {
            ListNode next = cur.next;
            cur.next = preNode.next;
            preNode.next = cur;
            mNode.next = next;
            cur = next;
            i++;
        }
        return dummy.next;
    }
    
    public class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x)	{ val = x; }
    }
}
//http://blog.csdn.net/linhuanmars/article/details/24613781