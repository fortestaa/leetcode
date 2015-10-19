package easy;

/**
 * 14. Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class No14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null)   return null;
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        
        String word = strs[0];
        int prefixLength = word.length();
        for (int i = 1; i < strs.length; i++) {
            String nextWord = strs[i];
            prefixLength = Math.min(prefixLength, nextWord.length());
            for (int j = 0; j < prefixLength; j++) {
                if (word.charAt(j) != nextWord.charAt(j)) {
                    prefixLength = j;
                    break;
                }
            }
        }
        return word.substring(0, prefixLength);
    }
}
