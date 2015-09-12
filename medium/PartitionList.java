package medium;

/**
 * 86 Partition List
 * https://leetcode.com/problems/partition-list/
 * 
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
    	if (head == null || head.next == null)
    		return head;
        ListNode small = new ListNode(-1);
        ListNode shead = small;
        ListNode big = new ListNode(-1);
        ListNode bhead = big;
        
        while (head != null) {
        	if (head.val < x) {
        		small.next = head;
        		small = small.next;
        	} else {
        		big.next = head;
        		big = big.next;
        	}
        	head = head.next;
        }
        big.next = null;
        small.next = bhead.next;
        return shead.next;
    }
    //http://www.cnblogs.com/springfor/p/3862392.html
    
    public class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x)	{ val = x; }
    }
}