package medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 139 Word Break 
 * https://leetcode.com/problems/word-break/
 * 
 * Given a string s and a dictionary of words dict, 
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * 
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0)   return true;
        
        boolean[] rst = new boolean[s.length() + 1];
        rst[0] = true;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder str = new StringBuilder(s.substring(0, i + 1));
            for (int j = 0; j <= i; j++) {
                if (rst[j] && wordDict.contains(str.toString())) {
                    rst[i + 1] = true;
                    break;
                }
                str.deleteCharAt(0);
            }
        }
        return rst[s.length()];
    }
    
    public static void main(String[] args) {
    	WordBreak s = new WordBreak();
    	String str = "leetcode";
    	Set<String> dict = new HashSet<String>();
    	dict.add("leet");
    	dict.add("code");
    	System.out.println(s.wordBreak(str, dict));
    }
}
// http://www.cnblogs.com/springfor/p/3874731.html