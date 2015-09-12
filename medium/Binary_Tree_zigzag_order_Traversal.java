package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 103	Binary Tree Zigzag Level Order Traversal
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * 
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */
public class Binary_Tree_zigzag_order_Traversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> rst = new ArrayList<List<Integer>>();
    	if (root == null)	return rst;
    	
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.add(root);
    	
    	int num = 0;
    	boolean reverse = false;
    	
    	while (!queue.isEmpty()) {
    		num = queue.size();
        	List<Integer> level = new ArrayList<Integer>();
    		for (int i = 0; i < num; i++) {
    			TreeNode n = queue.poll();
    			level.add(n.val);
    			if (n.left != null)	queue.add(n.left);
    			if (n.right != null)	queue.add(n.right);
    		}
    		if (reverse) {
    			Collections.reverse(level);
    			reverse = false;
    		} else {
    			reverse = true;
    		}
    		rst.add(level);
    	}
    	return rst;
    }
	
    public static class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x)	{ val = x; }
    }
    
    public static void main(String[] args) {
    	Binary_Tree_zigzag_order_Traversal s = new Binary_Tree_zigzag_order_Traversal();
    	TreeNode root = new TreeNode(3);
    	TreeNode l1 = new TreeNode(9);
    	TreeNode r1 = new TreeNode(20);
    	root.left = l1;
    	root.right = r1;
    	TreeNode l2 = new TreeNode(15);
    	TreeNode r2 = new TreeNode(7);
    	r1.left = l2;
    	r1.right = r2;
    	System.out.println("begin");
    	List<List<Integer>> rst = s.zigzagLevelOrder(root);
    	for (int i = 0; i < rst.size(); i++) {
    		System.out.println(rst.get(i));
    	}
    }
}
//http://www.cnblogs.com/springfor/p/3891393.html