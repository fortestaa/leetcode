package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 22 Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/
 * 
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> rst = new ArrayList<String>();
        dfs(rst, "", n, n);
        return rst;
    }
    
    // left, right: number of ( ) left to be used
    private void dfs(List<String> rst, String s, int left, int right) {
        if (left > right)   return;
        if (left == 0 && right == 0) {
            rst.add(s);
            return;
        }
        if (left > 0) {
            dfs(rst, s + "(", left - 1, right);
        }
        if (right > 0) {
            dfs(rst, s + ")", left, right - 1);
        }
    }
}
// http://www.programcreek.com/2014/01/leetcode-generate-parentheses-java/