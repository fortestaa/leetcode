package medium;

/**
 * 91	Decode Ways
 * https://leetcode.com/problems/decode-ways/
 * 
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
The number of ways decoding "12" is 2.
 */
public class DecodeWays {
	public int numDecodings(String s) {
    	if (s == null || s.length() == 0)	return 0;
    	int[] dp = new int[s.length() + 1];
    	dp[0] = 1;
    	if (isvalid(s.substring(0,1)))
    		dp[1] = 1;
    	else
    		dp[1] = 0;
    	
    	for (int i = 2; i <= s.length(); i++) {
    		if (isvalid(s.substring(i - 1, i)))
    			dp[i] += dp[i - 1];
    		if (isvalid(s.substring(i - 2, i))) {
    			dp[i] += dp[i - 2];
    		}
    	}
    	return dp[s.length()];
    }
    
    public boolean isvalid(String s) {
    	if (s.charAt(0) == '0') 
    		return false;
    	int digit = Integer.parseInt(s);
    	return digit >= 1 && digit <= 26;
    }
}
//http://www.cnblogs.com/springfor/p/3896162.html
//http://www.cnblogs.com/yuzhangcmu/p/4115490.html