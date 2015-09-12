package medium;

import java.util.ArrayList;

import medium.Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal.TreeNode;

/**
 * 98 Validate Binary Search Tree
 * https://leetcode.com/problems/validate-binary-search-tree/
 * 
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's key. 
 * The right subtree of a node contains only nodes with keys greater than the node's key. 
 * Both the left and right subtrees must also be binary search trees. 
 * confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return valid(root, null, null);
    }
    
    private boolean valid(TreeNode p, Integer low, Integer high) {
        if (p == null)  return true;
        return (low == null || p.val > low)
                && (high == null || p.val < high) 
                && valid(p.left, low, p.val)
                && valid(p.right, p.val, high);
    }

    public boolean isValidBST1(TreeNode root) {
        ArrayList<Integer> pre = new ArrayList<Integer>();
        pre.add(null);
        return helper(root, pre);
    }   
    private boolean helper(TreeNode root, ArrayList<Integer> pre) {
        if (root == null)   return true;
        boolean left = helper(root.left, pre);
        if (pre.get(0) != null && root.val <= pre.get(0))   return false;
        pre.set(0, root.val);
        return left && helper(root.right, pre);
    }
    
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}
// http://blog.csdn.net/linhuanmars/article/details/23810735