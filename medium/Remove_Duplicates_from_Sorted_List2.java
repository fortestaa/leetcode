package medium;

/**
 * 82	Remove Duplicates from Sorted List II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * 
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
class Remove_Duplicates_from_Sorted_List2 {
    public ListNode deleteDuplicates(ListNode head) {
    	if (head == null)   return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && pre.next.val == cur.next.val) {
                cur = cur.next;
            }
            if (cur == pre.next) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }
    
    public class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x)	{ val = x; }
    }
}
//http://blog.csdn.net/linhuanmars/article/details/24389429