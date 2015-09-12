package hard;

/**
 * 124	Binary Tree Maximum Path Sum	
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * 
 * Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,
       1
      / \
     2   3
Return 6.
 */
public class BinaryTreeMaximumPathSum {
    private int maxSum;
    
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        findMax(root);
        return maxSum;
    }
    
    private int findMax(TreeNode p) {
        if (p == null)  return 0;
        int left = findMax(p.left);
        int right = findMax(p.right);
        maxSum = Math.max(p.val + left + right, maxSum);
        int ret = p.val + Math.max(left, right);
        return ret > 0 ? ret : 0;
    }
    
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x)	{ val = x; }
    }
}