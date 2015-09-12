package medium; 

/**
 * 129	Sum Root to Leaf Numbers
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * 
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
 */
public class Sum_Root_to_Leaf_Numbers {
	/*
	private int sum = 0;
	
    public int sumNumbers(TreeNode root) {
        if (root == null)	return 0;
        run(root, 0);
        return sum;
    }
    
    public void run(TreeNode root, int num) {
    	num = 10 * num + root.val;
    	
    	if (root.left == null && root.right == null) {
    		sum += num;
    	}
    	
    	if (root.left != null) {
    		run(root.left, num);
    	}
    	if (root.right != null) {
    		run(root.right, num);
    	}
    }*/
	
    public int sumNumbers(TreeNode root) {
        return sumhelper(root, 0);
    }
    
    public int sumhelper(TreeNode root, int levelBase) {
    	if (root == null)	return 0;
    	if (root.left == null && root.right == null)	return levelBase + root.val;
    	int nextLevelBase = (levelBase + root.val) * 10;
    	int leftSubTreeSum = sumhelper(root.left, nextLevelBase);
    	int rightSubTreeSum = sumhelper(root.right, nextLevelBase);
    	return leftSubTreeSum + rightSubTreeSum;
    }
    
    public static void main(String[] args) {
    	Sum_Root_to_Leaf_Numbers s = new Sum_Root_to_Leaf_Numbers();
    	TreeNode root = new TreeNode(1);
    	TreeNode l = new TreeNode(2);
    	TreeNode r = new TreeNode(3);
    	root.left = l;
    	root.right = r;
    	System.out.println(s.sumNumbers(root));
    }
    
    public static class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}
//http://blog.csdn.net/ljiabin/article/details/39478999