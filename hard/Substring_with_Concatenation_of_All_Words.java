package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 30	Substring with Concatenation of All Words
 * 
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * 
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * You should return the indices: [0,9]. (order does not matter).
 */
public class Substring_with_Concatenation_of_All_Words {
    public List<Integer> findSubstring(String s, String[] words) {
    	List<Integer> res = new ArrayList<Integer>();
    	if (s.length() < 1 || words.length < 1)	return res;
    	int len = words[0].length();
    	
    	HashMap<String, Integer> map = new HashMap<String, Integer>();
    	for (int i = 0; i < words.length; i++) {
    		if (map.containsKey(words[i])) {
    			map.put(words[i], map.get(words[i]) + 1);
    		} else {
    			map.put(words[i], 1);
    		}
    	}
    	
    	for (int i = 0; i <= s.length() - words.length * len; i++) {
    		int from = i;
    		String str = s.substring(from, from + len);
    		int cnt = 0;
    		while (map.containsKey(str) && map.get(str) > 0) {
    			map.put(str, map.get(str) - 1);
    			cnt++;
    			from += len;
    			if (from + len > s.length())	break;
    			str = s.substring(from, from + len);
    		}
    		
    		if (cnt == words.length) {
    			res.add(i);
    		}
    		
    		if (cnt > 0) {
    			map.clear();
    			for (int j = 0; j < words.length; j++) {
    				if (map.containsKey(words[j])) {
    					map.put(words[j], map.get(words[j]) + 1);
    				} else {
    					map.put(words[j], 1);
    				}
    			}
    		}
    	}
    	
    	return res;
    }
}
// http://www.w2bc.com/Article/14500
// Accepted Java O(n) solution using histogram: https://leetcode.com/discuss/45050/accepted-java-o-n-solution-using-histogram
// !