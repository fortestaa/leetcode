package easy;

/**
 * 226	Invert Binary Tree
 * https://leetcode.com/problems/invert-binary-tree/
 * 
 * Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet by Max Howell:
Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so fuck off.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
    	if (root == null) {
    		return root;
    	} 
    	
    	TreeNode left = root.left;
    	TreeNode right = root.right;
    	root.right = invertTree(left);
    	root.left = invertTree(right);
        return root;
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
//http://blog.csdn.net/zzc8265020/article/details/46473757