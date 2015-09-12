package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49 Group Anagrams
 * https://leetcode.com/problems/anagrams/
 * 
 * Given an array of strings, group anagrams together.
 * 
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], Return:
 * 
 * [ ["ate", "eat","tea"], ["nat","tan"], ["bat"] ] 
 * Note: 
 * 	For the return value, each inner list's elements must follow the lexicographic order. 
 * 	All inputs will be in lower-case. 
 * 
 * Update (2015-08-09): The signature of the function had been updated to return list<list<string>> instead of list<string>, as suggested here.
 * If you still see your function signature return a list<string>, please click the reload button to reset your code definition.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        Arrays.sort(strs);
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            if (map.containsKey(s)) {
                List<String> l = res.get(map.get(s));
                l.add(str);
            } else {
                List<String> l = new ArrayList<String>();
                l.add(str);
                res.add(l);
                map.put(s, res.size() - 1);
            }
        }
        return res;
    }
}
// https://leetcode.com/discuss/51907/accept-java-solution

// http://www.cnblogs.com/springfor/p/3874667.html
// http://blog.csdn.net/linhuanmars/article/details/21664747