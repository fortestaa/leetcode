package medium;

/**
 * 117	Populating Next Right Pointers in Each Node II
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * 
 * Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 */
public class PopulatingNextRightPointers2 {
	public void connect(TreeLinkNode root) {
        if (root == null)   return;
        
        //因此，这道题目首要是找到右孩子的第一个有效的next链接节点，然后再处理左孩子。然后依次递归处理右孩子，左孩子
        TreeLinkNode p = root.next; // next of [root's right child]
        while (p != null) {
            if (p.left != null) {
                p = p.left;
                break;
            }
            if (p.right != null) {
                p = p.right;
                break;
            }
            p = p.next;
        }
        
        if (root.right != null) {
            root.right.next = p;
        }
        
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = p;
            }
        }
        
        connect(root.right);
        connect(root.left);
    }
    
    public class TreeLinkNode {
    	int val;
    	TreeLinkNode left, right, next;
    	TreeLinkNode(int x) { val = x; }
    }
}
//http://www.cnblogs.com/springfor/p/3889327.html