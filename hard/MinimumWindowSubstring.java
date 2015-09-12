package hard;

import java.util.HashMap;

/**
 * 76 Minimum Window Substring
 * 
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * 
 * For example, 
 * S = "ADOBECODEBANC" 
 * T = "ABC" 
 * Minimum window is "BANC".
 * 
 * Note: If there is no such window in S that covers all characters in T, return the emtpy string "".
 * 
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int slen = s.length();
        int tlen = t.length();
        for (int i = 0; i < tlen; i++) {
            char c = t.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        
        int start = 0;
        int end = 0;
        int count = 0;
        int maxlen = slen + 1;
        String ret = "";
        for ( ; end < slen; end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0)    count++;
                while (count == tlen) {
                    char ch = s.charAt(start);
                    if (map.containsKey(ch)) {
                        map.put(ch, map.get(ch) + 1);
                        if (map.get(ch) > 0) {
                            if (end - start + 1 < maxlen) {
                                maxlen = end - start + 1;
                                ret = s.substring(start, end + 1);
                            }
                            count--;
                        }
                    }
                    start++;
                }
            }
        }
        
        return ret;
    }
    
    public static void main(String[] args) {
    	MinimumWindowSubstring s = new MinimumWindowSubstring();
    	System.out.println(s.minWindow("a", "aa"));
    }
}
// http://m.blog.csdn.net/blog/op_yu/38869773