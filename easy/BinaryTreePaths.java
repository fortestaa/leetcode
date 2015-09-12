package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 257	Binary Tree Paths
 * https://leetcode.com/problems/binary-tree-paths/
 * 
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * For example, given the following binary tree:
   1
 /   \
2     3
 \
  5
All root-to-leaf paths are: ["1->2->5", "1->3"]
 */
public class BinaryTreePaths {
	/**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
    	List<String> res = new ArrayList<String>();
    	if (root == null)   return res;
    	
    	dfs(root, String.valueOf(root.val), res);
    	return res;
    }
    
    private void dfs(TreeNode root, String str, List<String> res) {
    	if (root.left == null && root.right == null) {
    		res.add(str);
    	}
    	
    	if (root.left != null)	dfs(root.left, str + "->" + root.left.val, res);
    	if (root.right != null)	dfs(root.right, str + "->" + root.right.val, res);
    }
    
    public static void main(String[] args) {
    	BinaryTreePaths b = new BinaryTreePaths();
    	TreeNode root = new TreeNode(1);
    	TreeNode l1 = new TreeNode(2);
    	TreeNode r1 = new TreeNode(3);
    	TreeNode l2 = new TreeNode(5);
    	root.left = l1;
    	root.right = r1;
    	l1.right = l2;
    	System.out.println(b.binaryTreePaths(root));
    }
}
