package medium;

/**
 * 105	Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 */
public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        int plen = preorder.length;
        int ilen = inorder.length;
        return bt(preorder, 0, plen - 1, inorder, 0, ilen - 1);
    }
    
    public TreeNode bt(int[] pre, int pstart, int pend, int[] in, int istart, int iend) {
        if (pstart > pend || istart > iend)
            return null;
            
        int rootval = pre[pstart];
        int rootindex = 0;
        for (int i = istart; i <= iend; i++) {
            if (in[i] == rootval) {
                rootindex = i;
                break;
            }
        }
        int len = rootindex - istart;
        TreeNode root = new TreeNode(rootval);
        root.left = bt(pre, pstart + 1, pstart + len, in, istart, rootindex - 1);
        root.right = bt(pre, pstart + len + 1, pend, in, rootindex + 1, iend);
        return root;
    }
    
    public class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}
//http://www.cnblogs.com/springfor/p/3884034.html