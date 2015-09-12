package medium;

import java.util.*;

/**
 * 94	Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * 
 * Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */
public class Binary_Tree_Inorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }
    
    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null)   return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null)   return res;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
    
    public static class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x)	{ val = x; }
    }
    
    public static void main(String[] args) {
    	Binary_Tree_Inorder_Traversal s = new Binary_Tree_Inorder_Traversal();
    	TreeNode root = new TreeNode(1);
    	TreeNode r2 = new TreeNode(2);
    	TreeNode r3 = new TreeNode(3);
    	root.right = r2;
    	r2.left = r3;
    	System.out.println(s.inorderTraversal(root));
    }
}
// http://www.cnblogs.com/springfor/p/3877179.html