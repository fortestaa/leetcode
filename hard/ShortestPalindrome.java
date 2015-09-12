package hard;

/**
 * 214	Shortest Palindrome
 * https://leetcode.com/problems/shortest-palindrome/
 * 
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. 
 * Find and return the shortest palindrome you can find by performing this transformation.
 * 
 * For example:
 * Given "aacecaaa", return "aaacecaaa".
 * Given "abcd", return "dcbabcd".
 */
public class ShortestPalindrome {
	public String shortestPalindrome(String s) { 
		int j = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(j) == s.charAt(i)) {
				j += 1;
			}
		}
		if (j == s.length())	return s;
		String suffix = s.substring(j);
		return new StringBuilder(suffix).reverse().toString() + shortestPalindrome(s.substring(0, j)) + suffix;
	}    
    
    public static void main(String[] args) {
    	ShortestPalindrome s = new ShortestPalindrome();
    	System.out.println(s.shortestPalindrome("abb"));
    	System.out.println(s.shortestPalindrome("aba"));
    }
    
}
// http://www.rudy-yuan.net/archives/186/
// https://leetcode.com/discuss/51223/my-7-lines-recursive-java-solution
// http://blog.csdn.net/xudli/article/details/45931667
// http://blog.csdn.net/pointbreak1/article/details/45931551