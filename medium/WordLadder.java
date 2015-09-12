package medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 127	Word Ladder	
 * https://leetcode.com/problems/word-ladder/
 * 
 * Given two words (beginWord and endWord), and a dictionary, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
 */
public class WordLadder {
	public static int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if (wordDict.size() == 0)   return 0;
        LinkedList<String> words = new LinkedList<String>();
        words.add(beginWord);
        LinkedList<Integer>distance = new LinkedList<Integer>();
        distance.add(1);
        while (!words.isEmpty()) {
            String currWord = words.pop();
            int currDistance = distance.pop();
            if (currWord.equals(endWord)) {
                return currDistance;
            }
            for (int i = 0; i < currWord.length(); i++) {
                char[] currCharArr = currWord.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    currCharArr[i] = c;
                    String newWord = new String(currCharArr);
                    if (wordDict.contains(newWord)) {
                        words.add(newWord);
                        distance.add(currDistance + 1);
                        wordDict.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
    	String start = "hit";
    	String end = "cog";
    	HashSet<String> dict = new HashSet<String>();
    	dict.add("hot");
    	dict.add("dot");
    	dict.add("dog");
    	dict.add("lot");
    	dict.add("cog");
    	System.out.println(ladderLength(start, end, dict));
    }
}
//http://blog.csdn.net/soszou/article/details/37671965