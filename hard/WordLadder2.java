package hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 126	Word Ladder II
 * https://leetcode.com/problems/word-ladder-ii/
 * 
 * Given two words (start and end), and a dictionary's word list, find all shortest transformation sequence(s) from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list

For example,
Given:
start = "hit"
end = "cog"
wordList = ["hot","dot","dog","lot","log"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
  
Note:
All words have the same length.
All words contain only lowercase alphabetic characters.
 */
public class WordLadder2 {
    HashMap<String, Integer> path = new HashMap<String, Integer>();
    
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> path = new ArrayList<String>();
        if (start == null || end == null || start.length() != end.length()) return res;
        bfs(start, end, dict);
        dfs(end, start, dict, path, res);
        return res;
    }
    
    private void bfs(String start, String end, Set<String> dict) {
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        path.put(start, 0);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(end))    continue;
            for (int i = 0; i < current.length(); i++) {
                char[] arr = current.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    if (arr[i] == c)    continue;
                    arr[i] = c;
                    String newWord = new String(arr);
                    if (newWord.equals(end) || dict.contains(newWord)) {
                        if (path.get(newWord) == null ) {
                            int depth = path.get(current);
                            path.put(newWord, depth + 1);
                            queue.add(newWord);
                        }
                    }
                }
            }
        }
    }
    
    private void dfs(String start, String end, Set<String> dict, List<String> pathArray, List<List<String>> res) {
        if (start.equals(end)) {
            pathArray.add(start);
            Collections.reverse(pathArray);
            res.add(pathArray);
            return;
        }
        if (path.get(start) == null)    return;
        pathArray.add(start);
        int nextDepth = path.get(start) - 1;
        for (int i = 0; i < start.length(); i++) {
            char[] arr = start.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                if (arr[i] == c)    continue;
                arr[i] = c;
                String newWord = new String(arr);
                if (path.get(newWord) != null && path.get(newWord) == nextDepth) {
                    List<String> newPathArray = new ArrayList<String>(pathArray);
                    dfs(newWord, end, dict, newPathArray, res);
                }
            }
        }
    }
}
// http://blog.csdn.net/worldwindjp/article/details/19301355