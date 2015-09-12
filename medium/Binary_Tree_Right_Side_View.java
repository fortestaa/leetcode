package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199	Binary Tree Right Side View
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * 
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
 */
public class Binary_Tree_Right_Side_View {
    public List<Integer> rightSideView(TreeNode root) {
    	List<Integer> res = new ArrayList<Integer>();
    	if (root == null)	return res;
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	queue.add(null);
    	
    	while (!queue.isEmpty()) {
    		TreeNode node = queue.poll();
    		
    		if (node == null) {
    			if (queue.isEmpty()) {
    				break;
    			} else {
    				queue.add(null);
    			}
    		} else {
    			if (queue.peek() == null) {
    				res.add(node.val);
    			}
    			
    			if (node.left != null) {
    				queue.add(node.left);
    			}
    			
    			if (node.right != null) {
    				queue.add(node.right);
    			}
    		}
    	}
    	return res;
    }
    
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x)	{ val = x; }
    }
}
//http://blog.csdn.net/ljiabin/article/details/44900023