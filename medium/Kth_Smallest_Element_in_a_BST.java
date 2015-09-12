package medium;

import java.util.Stack;

/**
 * 230	Kth Smallest Element in a BST
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * 
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * Follow up: What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 * Hint: Try to utilize the property of a BST.
 */
public class Kth_Smallest_Element_in_a_BST {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode n = root;
        while (n.left != null) {
            stack.push(n);
            n = n.left;
        }
        
        while (k > 0 && (n != null || !stack.isEmpty())) {
            if (n == null) {
                n = stack.pop();
                if (--k == 0)   return n.val;
                n = n.right;
            } else {
                stack.push(n);
                n = n.left;
            }
        }
        return n.val;
    }
    
    public static class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
    
    public static void main(String[] args) {
    	Kth_Smallest_Element_in_a_BST s = new Kth_Smallest_Element_in_a_BST();
    	TreeNode root = new TreeNode(1);
    	TreeNode n = new TreeNode(2);
    	root.right = n;
    	System.out.println(s.kthSmallest(root, 2));
    }
}
// http://blog.csdn.net/xudli/article/details/46784263