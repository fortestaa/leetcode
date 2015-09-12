package medium;

/**
 * 222	Count Complete Tree Nodes
 * https://leetcode.com/problems/count-complete-tree-nodes/
 * 
 * Given a complete binary tree, count the number of nodes.
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, 
 * and all nodes in the last level are as far left as possible. 
 * It can have between 1 and 2h nodes inclusive at the last level h.
 */
public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
        if (root == null)	return 0;
        
        int l = getleft(root);
        int r = getright(root);
        
        if (l == r) {
        	return (2 << l) - 1;
        } else {
        	return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }
    
    private int getleft(TreeNode root) {
    	int count = 0;
    	while (root.left != null) {
    		count++;
    		root = root.left;
    	}
    	return count;
    }
    
    private int getright(TreeNode root) {
    	int count = 0;
    	while (root.right != null) {
    		count++;
    		root = root.right;
    	}
    	return count;
    }
    
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x)	{ val = x; }
    }
}