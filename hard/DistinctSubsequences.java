package hard;

/**
 * 115 Distinct Subsequences
 * https://leetcode.com/problems/distinct-subsequences/
 * 
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example: S = "rabbbit", T = "rabbit"
 * Return 3.
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
    	if (t.length() == 0)	return 1;
    	if (s.length() == 0)	return 0;
    	int[] res = new int[t.length() + 1];
    	res[0] = 1;
    	for (int i = 0; i < s.length(); i++) {
    		for (int j = t.length() - 1; j >= 0; j--) {
    			res[j + 1] = (s.charAt(i) == t.charAt(j) ? res[j] : 0) + res[j + 1];
    		}
    	}
    	return res[t.length()];
    }
    // res[i][j]，对应的值是S的前i个字符和T的前j个字符有多少个可行的序列（注意这道题是序列，不是子串，也就是只要字符按照顺序出现即可，不需要连续出现）
    // res[i][j]=(S[i]==T[j]?res[i-1][j-1]:0)+res[i-1][j]。
    // 算法进行两层循环，时间复杂度是O(m*n)，而空间上只需要维护当前i对应的数据就可以，也就是O(m)
    /*这是动态规划里面的小细节~ 主要是因为我们省去了一维的空间，每次迭代我们只保存了上一行的信息。接下来从前往后还是从后往前就取决于我们要用的是更新前还是更新后的信息，如果从前往后，我们会使用更新后的信息。而这里我们是需要上一行旧的值，所以就应该从后往前扫了~
     * 以此为例：如果要求res[k]，第k列的值，需要上一行第k列和第k－1列的值，即需要这次iteration为止没有改变的res[k],res[k-1]，那么k－1是不能有变化的（即更新前的信息），所以应该从右往做遍历
     * */

    public int numDistinct1(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= s.length(); i++)   dp[i][0] = 1;
        for (int j = 1; j <= t.length(); j++)   dp[0][j] = 0;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                dp[i][j] = dp[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
// http://m.blog.csdn.net/blog/linhuanmars/23589057
// 要不要抛弃当前字符
// http://blog.csdn.net/worldwindjp/article/details/19770281
// http://www.cnblogs.com/springfor/p/3896152.html?utm_source=tuicool