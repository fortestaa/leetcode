package hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 68 Text Justification
 * https://leetcode.com/problems/text-justification/
 * 
 * Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. 
 * Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. 
 * If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * 
 * For example, 
 * words: ["This", "is", "an", "example", "of", "text", "justification."] 
 * L: 16.
 * Return the formatted lines as: 
 * [
 *  "This    is    an",
 *  "example  of text", 
 *  "justification.  " 
 * ] 
 * 
 * Note: Each word is guaranteed not to exceed L in length.
 */
public class TextJustification {
	public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        
        int n = words.length;
        int i = 0;
        while (i < n) {
            int len = words[i].length();
            int j = i + 1;
            while (j < n && len + 1 + words[j].length() <= maxWidth) {
                len += 1 + words[j].length();
                j++;
            }
            
            String line = words[i];
            if (j == n) {	// if this is the last line
                for (int k = i + 1; k < n; k++) {
                    line += " " + words[k];
                }
                while (line.length() < maxWidth) {
                    line += " ";
                }
            } else {
                int extraWhite = maxWidth - len;
                int whiteNum = j - i - 1;	// lastindex = j - 1, firstindex = i ----- [1-10]=9=lastindex - firstindex
                if (whiteNum == 0) {	// if this line has only one word
                    while (line.length() < maxWidth) {
                        line += " ";
                    }
                } else {
                    for (int k = i + 1; k < j; k++) {
                        line += " ";
                        for (int p = 0; p < extraWhite / whiteNum; p++) {
                            line += " ";
                        }
                        if (k - i <= extraWhite % whiteNum) {	// (extraWhite % whiteNum) extra white spaces are needed
                            line += " ";
                        }
                        line += words[k];
                    }
                }
            }
            res.add(line);
            i = j;
        }
        return res;
    }
}
// http://blog.csdn.net/ljiabin/article/details/44976999