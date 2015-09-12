package easy;

import java.util.HashMap;

/**
 * 205	Isomorphic Strings
 * https://leetcode.com/problems/isomorphic-strings/
 * 
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters. 
 * No two characters may map to the same character but a character may map to itself.
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        int slen = s.length();
        int tlen = t.length();
        int len = Math.max(slen, tlen);
        for (int i = 0; i < len; i++) {
        	char sc = (i < slen) ? s.charAt(i) : ' ';
        	char tc = (i < tlen) ? t.charAt(i) : ' ';
        	if (!map.containsKey(sc)) {
        		if (map.containsValue(tc)) {
        			return false;
        		}
        		map.put(sc, tc);
        	} else {
        		if (map.get(sc) != tc) {
        			return false;
        		}
        	}
        }
        return true;
    }
    // self
    
    public static void main(String[] args) {
    	IsomorphicStrings s = new IsomorphicStrings();
    	System.out.println("egg, add: " + s.isIsomorphic("egg", "add"));
    	System.out.println("foo, bar: " + s.isIsomorphic("foo", "bar"));
    	System.out.println("paper, title: " + s.isIsomorphic("paper", "title"));
    	
    	System.out.println("ab, ba: " + s.isIsomorphic("ab", "ba"));
    	System.out.println("ab, aa: " + s.isIsomorphic("ab", "aa"));
    }
}
// other includes set
//http://blog.csdn.net/xudli/article/details/45386777