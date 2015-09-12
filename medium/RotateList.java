package medium;

/**
 * 61 Rotate List
 * https://leetcode.com/problems/rotate-list/
 * 
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * 
 * For example: Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ListNode p = head;
        int len = 1;
        while (p.next != null) {
            len++;
            p = p.next;
        }
        p.next = head;
        k = k % len;
        for (int i = 0; i < len - k; i++) {
            p = p.next;
        }
        head = p.next;
        p.next = null;
        return head;
    }
    
    public class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) { val = x; }
    }
}
/*
看别人思路：这个既然要rotate，不如先连起来loop，这样怎么也不怕null pointer exception了。然后再找到该断开的地方断开。
*/
// https://leetcodenotes.wordpress.com/2013/08/14/leetcode-rotate-list-把后k个rotate到list前面去，k可以超过list本身长度/