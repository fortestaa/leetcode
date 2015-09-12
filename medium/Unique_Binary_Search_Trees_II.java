package medium;

import java.util.ArrayList;
import java.util.List;

import medium.Binary_Tree_Inorder_Traversal.TreeNode;

/**
 * 95	Unique Binary Search Trees II
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 * 
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 */
public class Unique_Binary_Search_Trees_II {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }
    
    private List<TreeNode> generateTrees(int left, int right) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (left > right) {
            res.add(null);
            return res;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> lefts = generateTrees(left, i - 1);
            List<TreeNode> rights = generateTrees(i + 1, right);
            for (int j = 0; j < lefts.size(); j++) {
                for (int k = 0; k < rights.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = lefts.get(j);
                    root.right = rights.get(k);
                    res.add(root);
                }
            }
        }
        return res;
    } 

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
// http://www.cnblogs.com/springfor/p/3884029.html