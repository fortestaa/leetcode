package medium;

/**
 * 109	Convert Sorted List to Binary Search Tree
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * 
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class Convert_Sorted_List_to_Binary_Search_Tree {
    private ListNode list;
    
    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            n++;
        }
        list = head;
        return sortedListToBST(0, n - 1);
    }
    
    private TreeNode sortedListToBST(int start, int end) {
        if (start > end)    return null;
        int mid = (start + end) / 2;
        TreeNode leftChild = sortedListToBST(start, mid - 1);
        TreeNode parent = new TreeNode(list.val);
        parent.left = leftChild;
        list = list.next;
        parent.right = sortedListToBST(mid + 1, end);
        return parent;
    }

    public class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) { val = x; }
    }

    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x)	{ val = x; }
    }
}