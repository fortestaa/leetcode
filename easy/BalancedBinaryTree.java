package easy;

/**
 * 110	Balanced Binary Tree
 * https://leetcode.com/problems/balanced-binary-tree/
 * 
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null)   return true;
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
            && isBalanced(root.left)
            && isBalanced(root.right);
    }
    
    private int maxDepth(TreeNode n) {
        if (n == null)  return 0;
        return Math.max(maxDepth(n.left), maxDepth(n.right)) + 1;
    }

    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x)	{ val = x; }
    }
}