package easy;

/**
 * 101	Symmetric Tree
 * https://leetcode.com/problems/symmetric-tree/
 * 
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.

confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)   return true;
        return isSymmetric(root.left, root.right);
    }
    
    private boolean isSymmetric(TreeNode l, TreeNode r) {
        if (l == null || r == null) {
            return (l == null && r == null);
        }
        return l.val == r.val && isSymmetric(l.left, r.right) && isSymmetric(l.right, r.left);
    }

    public static class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}