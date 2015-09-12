package hard;

import java.util.ArrayList;

/**
 * 99	Recover Binary Search Tree
 * https://leetcode.com/problems/recover-binary-search-tree/
 * 
 * Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */
public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        if (root == null)   return;
        ArrayList<TreeNode> pre = new ArrayList<TreeNode>();
        pre.add(null);
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        helper(root, pre, res);
        if (res.size() != 0) {
            int temp = res.get(0).val;
            res.get(0).val = res.get(1).val;
            res.get(1).val = temp;
        }
    }
    
    private void helper(TreeNode root, ArrayList<TreeNode> pre, ArrayList<TreeNode> res) {
        if (root == null)   return;
        helper(root.left, pre, res);
        if (pre.get(0) != null && pre.get(0).val > root.val) {
            if (res.size() == 0) {
                res.add(pre.get(0));
                res.add(root);
            } else {
                res.set(1, root);
            }
        }
        pre.set(0, root);
        helper(root.right, pre, res);
    }
    // http://blog.csdn.net/linhuanmars/article/details/24566995

	/**
	 * Definition for a binary tree node.
	 */ 
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

    TreeNode mistake1, mistake2;
    TreeNode pre;
    
    public void recoverTree1(TreeNode root) {
        recursive_traversal(root);
        if (mistake1 != null && mistake2 != null) {
            int tmp = mistake1.val;
            mistake1.val = mistake2.val;
            mistake2.val = tmp;
        }
    }   
    private void recursive_traversal(TreeNode root) {
        if (root == null)   return;
        
        if (root.left != null)  recursive_traversal(root.left);
        if (pre != null && root.val < pre.val) {
            if (mistake1 == null) {
                mistake1 = pre;
                mistake2 = root;
            } else {
                mistake2 = root;
            }
        }
        pre = root;
        if (root.right != null) recursive_traversal(root.right);
    }
}
// http://blog.csdn.net/worldwindjp/article/details/21694179