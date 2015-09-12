package hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 140 Word Break II
 * https://leetcode.com/problems/word-break-ii/
 * 
 * Given a string s and a dictionary of words dict, 
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * Return all such possible sentences.
 * 
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 */
public class Word_Break2 {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0)   return res;
        if (wordBreakCheck(s, wordDict))    helper(s, wordDict, 0, "", res);
        return res;
    } 
    
    private boolean wordBreakCheck(String s, Set<String> dict) {
        if (s == null || s.length() == 0)   return true;
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder str = new StringBuilder(s.substring(0, i + 1));
            for (int j = 0; j <= i; j++) {
                if (res[j] && dict.contains(str.toString())) {
                    res[i + 1] = true;
                    break;
                }
                str.deleteCharAt(0);
            }
        }
        return res[s.length()];
    }
    
    private void helper(String s, Set<String> dict, int start, String item, List<String> res) {
        if (start >= s.length()) {
            res.add(item);
            return;
        }
        
        StringBuilder str = new StringBuilder();
        for (int i = start; i < s.length(); i++) {
            str.append(s.charAt(i));
            if (dict.contains(str.toString())) {
                String newItem = item.length() > 0 ? (item + " " + str.toString()) : str.toString();
                helper(s, dict, i + 1, newItem, res);
            }
        }
    }
}
// http://www.cnblogs.com/springfor/p/3877056.html?utm_source=tuicool
// http://www.tuicool.com/articles/ZVJJRrF