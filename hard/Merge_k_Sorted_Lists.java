package hard;

/**
 * 23	Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class Merge_k_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
            
        int end = lists.length - 1;
        while (end > 0) {
            int begin = 0;
            while (begin < end) {
                lists[begin] = merge2Lists(lists[begin], lists[end]);
                begin++;
                end--;
            }
        }
        return lists[0];
    }
    
    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode dummyhead = new ListNode(0);
        ListNode p = dummyhead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
        return dummyhead.next;
    }
    
    public class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) {
    		val = x;
    		next = null;
    	}
    }
}
