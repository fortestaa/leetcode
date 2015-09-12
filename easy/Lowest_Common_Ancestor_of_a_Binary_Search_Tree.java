package easy;

/**
 * 235	Lowest Common Ancestor of a Binary Search Tree
 * 
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 */
public class Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
	// 我自己的做法
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)	return null;
        while (root != null) {
        	if (root.val == p.val)	return root;
        	if (root.val == q.val)	return root;
        	if ((p.val - root.val) * (q.val - root.val) < 0) {
        		return root;
        	} else if (p.val < root.val) {
        		root = root.left;
        	} else {
        		root = root.right;
        	}
        }
        return null;
    }
    
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)	return null;
        
        if (Math.max(p.val, q.val) < root.val) {
        	return lowestCommonAncestor1(root.left, p, q);
        } else if (Math.min(p.val, q.val) > root.val) {
        	return lowestCommonAncestor1(root.right, p, q);
        } else {
        	return root;
        }
    }
    // http://blog.csdn.net/xudli/article/details/46838747
    
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}