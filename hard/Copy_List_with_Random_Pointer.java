package hard;

/**
 * 138	Copy List with Random Pointer
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * 
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 */
public class Copy_List_with_Random_Pointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)   return null;
        
        RandomListNode node = head;
        RandomListNode temp = null;
        // 原链表里在每个节点后面加新节点（new.label = old.label）
        while (node != null) {
            temp = node.next;
            
            RandomListNode newNode = new RandomListNode(node.label);
            node.next = newNode;
            newNode.next = temp;
            
            node = temp;
        }
        
        // update new node's random
        // 通过画图可以清晰看出 newnode.random = old.random.next (newnode为新加的节点 old为新加节点之前的旧节点)
        node = head;
        while (node != null) {
            if (node.random != null) {
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        
        // 恢复原始链表以及构建新链表
        // old1.next = old1.next.next
        // new1.next = new1.next.next
        node = head;
        RandomListNode newHead = head.next;
        RandomListNode newNode = node.next;
        while (node != null) {
            node.next = newNode.next;
            if (newNode.next != null)   newNode.next = newNode.next.next;
            node = node.next;
            if (node != null)   newNode = node.next;
        }
        return newHead;
    }

	/**
	 * Definition for singly-linked list with a random pointer.
	 */
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};
}
// http://www.cnblogs.com/easonliu/p/3647160.html	看图解
// http://blog.csdn.net/fytain/article/details/12423861	代码