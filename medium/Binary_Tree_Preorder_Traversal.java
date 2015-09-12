package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144	Binary Tree Preorder Traversal
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * 
 * Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
 */
public class Binary_Tree_Preorder_Traversal {
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> rst = new ArrayList<Integer>();
    	if (root == null)	return rst;
    	Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);
        
        while (!st.isEmpty()) {
        	TreeNode tmp = st.pop();
        	rst.add(tmp.val);
        	if (tmp.right != null)
        		st.push(tmp.right);
        	if (tmp.left != null)
        		st.push(tmp.left);
        }
    	return rst;
    }
    
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x)	{ val = x; }
    }
}
//http://www.tuicool.com/articles/Yz2QJn