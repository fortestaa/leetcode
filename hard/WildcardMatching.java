package hard;

/**
 * 44 Wildcard Matching
 * 
 * Implement wildcard pattern matching with support for '?' and '*'.
 * 
 * '?' Matches any single character. 
 * '*' Matches any sequence of characters (including the empty sequence).
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be: 
 * bool isMatch(const char *s, const char *p)
 * 
 * Some examples: 
 * isMatch("aa","a") → false 
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false 
 * isMatch("aa", "*") → true 
 * isMatch("aa", "a*") → true 
 * isMatch("ab", "?*") → true 
 * isMatch("aab", "c*a*b") → false
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int sum = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                sum++;
            }
        }
        if (sum > s.length())   return false;
        
        int slen = s.length() + 1;
        int plen = p.length() + 1;
        boolean[][] dp = new boolean[slen][plen];
        dp[0][0] = true;
        for (int i = 1; i < plen; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        
        for (int i = 1; i < slen; i++) {
            for (int j = 1; j < plen; j++) {
                if (p.charAt(j - 1) == '*' && (dp[i - 1][j] || dp[i - 1][j - 1] || dp[i][j - 1])) {
                    dp[i][j] = true;
                } else if (dp[i - 1][j - 1] && (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1))) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[slen - 1][plen - 1];
    }
}
// http://www.cnblogs.com/nanpo/archive/2013/07/09/3180967.html
// 以上动态规划法；另外有贪心等等未研究