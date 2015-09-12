package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Postorder_Traversal {
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> rst = new ArrayList<Integer>();
        if (root == null)	return rst;
        Stack<TreeNode> st = new Stack<TreeNode>();
        HashSet<TreeNode> hs = new HashSet<TreeNode>();
        
        st.push(root); 
        while (!st.isEmpty()) {
        	TreeNode tmp = st.pop();
        	if (hs.contains(tmp)) {
        		rst.add(tmp.val);
        		continue;
        	}
        	hs.add(tmp);
        	st.push(tmp);
        	if (tmp.right != null)	st.push(tmp.right);
        	if (tmp.left != null)	st.push(tmp.left);
        }
        return rst;
    }
    
    public static class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x)	{ val = x; }
    }
}
