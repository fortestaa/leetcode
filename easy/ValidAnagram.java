package easy;

import java.util.HashMap;

/**
 * 242	Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 * 
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * Note: You may assume the string contains only lowercase alphabets.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
        	if (map.containsKey(c)) {
        		map.put(c, map.get(c) + 1);
        	} else {
        		map.put(c, 1);
        	}
        }
        
        for (char c : t.toCharArray()) {
        	if (!map.containsKey(c))	return false;
        	map.put(c, map.get(c) - 1);
        	if (map.get(c) == 0)	map.remove(c);
        }
        return map.isEmpty();
    }
    
    public static void main(String[] args) {
    	ValidAnagram s = new ValidAnagram();
    	System.out.println(s.isAnagram("ab", "a"));
    }
}
