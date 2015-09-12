package medium;

import java.util.ArrayList;

/**
 * 114	Flatten Binary Tree to Linked List
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * 
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

Hints: If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
 */
public class Flatten_Binary_Tree_to_Linked_List {
    public void flatten(TreeNode root) {
        if (root == null)   return;
        ArrayList<TreeNode> pre = new ArrayList<TreeNode>();
        pre.add(null);
        helper(root, pre);
    }
    
    private void helper(TreeNode root, ArrayList<TreeNode> pre) {
        if (root == null)   return;
        if (pre.get(0) != null) {
            pre.get(0).left = null;
            pre.get(0).right = root;
        }
        pre.set(0, root);
        TreeNode right = root.right;
        helper(root.left, pre);
        helper(right, pre);
    }
    //http://blog.csdn.net/linhuanmars/article/details/23717703

	private TreeNode lastvisit = null;
    public void flatten0(TreeNode root) {
    	if (root == null)
    		return;
    	TreeNode savedright = root.right;
    	if (lastvisit != null) {
    		lastvisit.left = null;
    		lastvisit.right = root;
    	}
    	lastvisit = root;
    	flatten0(root.left);
    	flatten0(savedright);
    }
    
    public void flatten2(TreeNode root) {
    	while (root != null) {
    		if (root.left != null) {
    			TreeNode p = root.left;
    			while (p.right != null) {
    				p = p.right;
    			}
    			p.right = root.right;
    			root.right = root.left;
    			root.left = null;
    		}
    		root = root.right;
    	}
    }
    
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}
//http://blog.csdn.net/perfect8886/article/details/20000083