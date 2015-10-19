package medium;

/**
 * 2 Add Two Numbers
 * https://leetcode.com/problems/add-two-numbers/
 * 
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 */
public class No2_AddTwoNumbers {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode p = l1, q = l2, curr = dummyHead;
		int carry = 0;
		
		while (p != null || q != null) {
			int x = (p == null) ? 0 : p.val;
			int y = (q == null) ? 0 : q.val;
			int digit = carry + x + y;
			carry = digit / 10;
			curr.next = new ListNode(digit % 10);
			curr = curr.next;
			if (p != null)	p = p.next;
			if (q != null)	q = q.next;
		}
		if (carry > 0)	curr.next = new ListNode(carry);
		return dummyHead.next;
	}
	
	public static void main(String[] args) {
		AddTwoNumbers s = new AddTwoNumbers();
		
		ListNode l1 = new ListNode(2);
		ListNode l11 = new ListNode(4);
		ListNode l12 = new ListNode(3);
		l1.next = l11;
		l11.next = l12;

		ListNode l2 = new ListNode(5);
		ListNode l21 = new ListNode(6);
		ListNode l22 = new ListNode(4);
		l2.next = l21;
		l21.next = l22;
		
		ListNode rst = s.addTwoNumbers(l1, l2);
		while (rst != null) {
			System.out.println(rst.val);
			rst = rst.next;
		}
	}
}
