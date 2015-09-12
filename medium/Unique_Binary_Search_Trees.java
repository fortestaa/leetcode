package medium;

/**
 * 96	Unique Binary Search Trees
 * https://leetcode.com/problems/unique-binary-search-trees/
 * 
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class Unique_Binary_Search_Trees {
	public int numTrees(int n) {
        if (n < 0)  return 0;
        int[] res = new int[n + 1];	//1-n之间构造的bst的个数
        res[0] = 1;
        res[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                res[i] += res[j] * res[i - 1 - j];	//左边j个数，右边i－1-j个数
            }
        }
        return res[n];
    }

	/*	Time Limit Exceeded
    public int numTrees(int n) {
    	if (n == 1)	return 1;
    	int result = 0;
    	for (int i = 1; i <= n; i++)
    		result += rst(n, i);
    	return result;
    }
    
    public int rst(int n, int root) {	// n个数字，以第root大数字为root
    	if (n == 1)	return 1;
    	int left = numTrees(root - 1);	// 1~i-1,左子树
    	int right = numTrees(n - root);	//i+1~n，右子树
    	if (left == 0) {
    		return right;
    	}
    	if (right == 0) {
    		return left;
    	}
    	return left * right;
    }*/
    
    public static void main(String[] args) {
    	Unique_Binary_Search_Trees s = new Unique_Binary_Search_Trees();
    	System.out.println(s.numTrees(19));
    }
}
// http://blog.csdn.net/linhuanmars/article/details/24761459
//http://www.blogjava.net/menglee/archive/2013/12/20/407801.html