package hard;

/**
 * 32 Longest Valid Parentheses
 * https://leetcode.com/problems/longest-valid-parentheses/
 * 
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class Longest_Valid_Parentheses {
    public int longestValidParentheses(String s) {
    	int size = s.length();
    	int[] dp = new int[size];
    	for (int i = 0; i < size; i++) {
    		dp[i] = 0;
    	}
    	
    	int max = 0;
    	for (int i = size - 2; i >= 0; i--) {
    		if (s.charAt(i) == '(') {
    			int j = i + 1 + dp[i + 1];
    			if (j < size && s.charAt(j) == ')') {
    				dp[i] = dp[i + 1] + 2;
    				if (j + 1 < size) {
    					dp[i] += dp[j + 1];
    				}
    			}
    		}
    		if (max <= dp[i]) {
    			max = dp[i];
    		}
    	}
        
        return max;
    }
    // http://blog.csdn.net/cfc1243570631/article/details/9304525
    // dp[i]表示从s[i]到s[s.length - 1]包含s[i]的最长的有效匹配括号子串长度。
}
// http://blog.csdn.net/a83610312/article/details/8639790