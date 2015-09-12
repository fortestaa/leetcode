package medium;

/**
 * 151 Reverse Words in a String 
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * 
 * Given an input string, reverse the string word by word.
 * 
 * For example, Given s = "the sky is blue", return "blue is sky the".
 * 
 * click to show clarification.
 * Clarification: 
 * What constitutes a word? A sequence of non-space characters constitutes a word. 
 * Could the input string contain leading or trailing spaces? Yes. However, your reversed string should not contain leading or trailing spaces. 
 * How about multiple spaces between two words? Reduce them to a single space in the reversed string.
 */
public class Reverse_Words_in_a_String {
    public String reverseWords(String s) {
        StringBuilder reversed = new StringBuilder();
        int j = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                j = i;
            } else if (i == 0 || s.charAt(i - 1) == ' ') {
                if (reversed.length() != 0) {
                    reversed.append(' ');
                }
                reversed.append(s.substring(i, j));
            }
        }
        return reversed.toString();
    }
}