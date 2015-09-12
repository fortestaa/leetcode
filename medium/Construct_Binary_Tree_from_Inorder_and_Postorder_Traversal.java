package medium;

/**
 * 106	Construct Binary Tree from Inorder and Postorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 */
public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        int ilen = inorder.length;
        int plen = postorder.length;
        return bt(inorder, 0, ilen - 1, postorder, 0, plen - 1);
    }
    
    public TreeNode bt(int[] in, int istart, int iend, int[] post, int pstart, int pend) {
        if (istart > iend || pstart > pend) return null;
        int rootval = post[pend];
        int rootindex = 0;
        for (int i = 0; i <= iend; i++) {
            if (in[i] == rootval) {
                rootindex = i;
                break;
            }
        }
        int len = rootindex - istart;
        TreeNode root = new TreeNode(rootval);
        root.left = bt(in, istart, rootindex - 1, post, pstart, pstart + len - 1);
        root.right = bt(in, rootindex + 1, iend, post, pstart + len, pend - 1);
        return root;
    }
    
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}