package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 131	Palindrome Partitioning
 * https://leetcode.com/problems/palindrome-partitioning/
 * 
 * Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
    	List<List<String>> rst = new ArrayList<List<String>>();
    	List<String> item = new ArrayList<String>();
        
        if (s == null || s.length() == 0) {
        	return rst;
        }
        dfs(s, 0, item, rst);
        return rst;
    }
    
    private void dfs(String s, int start, List<String> item, List<List<String>> rst) {
    	if (start == s.length()) {
    		rst.add(new ArrayList<String>(item));
    		return;
    	}
    	for (int i = start; i < s.length(); i++) {
    		String str = s.substring(start, i + 1);
    		if (isPalindrome(str)) {
    			item.add(str);
    			dfs(s, i + 1, item, rst);
    			item.remove(item.size() - 1);
    		}
    	}
    }
    
    private boolean isPalindrome(String s) {
    	int low = 0;
    	int high = s.length() - 1;
    	while (low < high) {
    		if (s.charAt(low) != s.charAt(high))
    			return false;
    		low++;
    		high--;
    	}
    	return true;
    }
    
    public static void main(String[] args) {
    	PalindromePartitioning s = new PalindromePartitioning();
    	String str = "aab";
    	List<List<String>> rst = s.partition(str);
    	for (int i = 0; i < rst.size(); i++) {
        	System.out.println(rst.get(i));
    	}
    }
}
//http://www.cnblogs.com/springfor/p/3884197.html