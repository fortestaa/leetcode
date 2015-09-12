package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 236	Lowest Common Ancestor of a Binary Tree
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
 * For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 */
public class Lowest_Common_Ancestor_of_a_Binary_Tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)	return null;
        
        List<TreeNode> pathp = new ArrayList<TreeNode>();
        List<TreeNode> pathq = new ArrayList<TreeNode>();
        pathp.add(root);
        pathq.add(root);
        
        getPath(root, p, pathp);
        getPath(root, q, pathq);
        
        TreeNode lca = null;
        for (int i = 0; i < pathp.size() && i < pathq.size(); i++) {
        	if (pathp.get(i) == pathq.get(i))	lca = pathp.get(i);
        	else	break;
        }
        return lca;
    }
    
    private boolean getPath(TreeNode root, TreeNode n, List<TreeNode> path) {
    	if (root == n) {
    		return true;
    	}
    	
    	if (root.left != null) {
    		path.add(root.left);
    		if (getPath(root.left, n, path))	return true;
    		path.remove(path.size() - 1);
    	}
    	
    	if (root.right != null) {
    		path.add(root.right);
    		if (getPath(root.right, n, path))	return true;
    		path.remove(path.size() - 1);
    	}
    	
    	return false;
    }
    
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}
// http://blog.csdn.net/xudli/article/details/46838747