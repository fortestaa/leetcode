package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 113	Path Sum II	
 * https://leetcode.com/problems/path-sum-ii/
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 */
public class Path_Sum_II {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> rst = new ArrayList<List<Integer>>();
    	List<Integer> item = new ArrayList<Integer>();
    	dfs(root, sum, item, rst);
    	return rst;
    }
    
    public void dfs(TreeNode root, int sum, List<Integer> item, List<List<Integer>> rst) {
    	if (root == null)
    		return;
    	if (root.left == null && root.right == null) {
    		if (root.val == sum) {
	    		item.add(root.val);
	    		rst.add(new ArrayList<Integer>(item));
	    		item.remove(item.size() - 1);
    		}
    		return;
    	}
    	item.add(root.val);
    	if (root.left != null) {
    		dfs(root.left, sum - root.val, item, rst);
    	}
    	if (root.right != null) {
    		dfs(root.right, sum - root.val, item, rst);
    	}
    	item.remove(item.size() - 1);
    }
    
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}