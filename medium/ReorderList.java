package medium;

/**
 * 143	Reorder List
 * https://leetcode.com/problems/reorder-list/
 * 
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;

		ListNode slow = head, fast = head;
		ListNode firsthalf = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode secondhalf = slow.next;
		slow.next = null;	// important!
		secondhalf = reverseOrder(secondhalf);

		while (secondhalf != null) {
			ListNode temp1 = firsthalf.next;
			ListNode temp2 = secondhalf.next;

			firsthalf.next = secondhalf;
			secondhalf.next = temp1;

			firsthalf = temp1;
			secondhalf = temp2;
		}
	}

	public static ListNode reverseOrder(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode pre = head;
		ListNode curr = head.next;
		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = pre;
			pre = curr;
			curr = temp;
		}
		head.next = null;
		return pre;
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