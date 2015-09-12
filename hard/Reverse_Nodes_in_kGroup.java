package hard;

/**
 * 25	Reverse Nodes in k-Group
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * 
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 */
public class Reverse_Nodes_in_kGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        
        while (pre.next != null) {
            ListNode last = pre.next;
            //找到第K个元素，看看是否为NULL  
            for (int i = 1; i < k && last != null; i++) {	//这里要判断Last是否为空，否则会出现空指针异常
                last = last.next;
            }
            
            //如果第K个元素存在
            if (last != null) {
                ListNode p = last.next;
                ListNode first = pre.next;
                ListNode cur = pre.next;
                ListNode post = cur.next;
                for (int i = 1; i < k; i++) {
                    ListNode tmp = post.next;
                    post.next = cur;
                    cur = post;
                    post = tmp;
                }
                pre.next = last;	//pre链接上最后一个 
                first.next = p;		//first链接上后一个group
                pre = first;		//pre挪到first，作为下一个group的pre
            } else {
            	//什么也不做，保持原来的顺序  
                break;
            }
        }
        head = dummy.next;
        return head;
    }
    // http://blog.csdn.net/chencheng126/article/details/39210647
    
    public static class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) {
    		val = x;
    		next = null;
    	}
    }
    
    public static void main(String[] args) {
    	Reverse_Nodes_in_kGroup s = new Reverse_Nodes_in_kGroup();
    	ListNode n1 = new ListNode(1);
    	ListNode n2 = new ListNode(2);
    	ListNode n3 = new ListNode(3);
    	ListNode n4 = new ListNode(4);
    	n1.next = n2;
    	n2.next = n3;
    	n3.next = n4;
    	
    	ListNode rst = s.reverseKGroup(n1, 3);
    	while (rst != null) {
    		System.out.println(rst.val);
    		rst = rst.next;
    	}
    }
}
// http://blog.csdn.net/xudli/article/details/8511521
// http://m.blog.csdn.net/blog/u013378502/38921937