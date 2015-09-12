package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 145	Binary Tree Postorder Traversal
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * 
 * Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
 */
public class Binary_Tree_Postorder_Traversal {
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<Integer>();
    	postorder(root, res);
    	return res;
    }
    
    private void postorder(TreeNode root, List<Integer> res) {
    	if (root == null)	return;
    	
    	postorder(root.left, res);
    	postorder(root.right, res);
    	res.add(root.val);
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