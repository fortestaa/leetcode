package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 211	Add and Search Word - Data structure design
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 * 
 * Design a data structure that supports the following two operations:
 * 
 * void addWord(word) 
 * bool search(word) 
 * 
 * search(word) can search a literal word or a regular expression string containing only letters a-z or . 
 * A . means it can represent any one letter.
 * 
 * For example:
 * 
 * addWord("bad") 
 * addWord("dad") 
 * addWord("mad") 
 * search("pad") -> false
 * search("bad") -> true 
 * search(".ad") -> true 
 * search("b..") -> true
 */
public class WordDictionary {
	private TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        HashMap<Character, TrieNode> children = root.children;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode t = null;
            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c, t);
            }
            children = t.children;
            if (i == word.length() - 1) t.leaf = true;
        }
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchNode(word, root);
    }
    
    private boolean searchNode(String word, TrieNode tn) {
        if (tn == null) return false;
        if (word.length() == 0) return tn.leaf;
        
        HashMap<Character, TrieNode> children = tn.children;
        char c = word.charAt(0);
        if (c == '.') {
            for (char key : children.keySet()) {
                if (searchNode(word.substring(1), children.get(key)))   return true;
            }
            return false;
        } else if (!children.containsKey(c)) {
            return false;
        } else {
            return searchNode(word.substring(1), children.get(c));
        }
    }
    
    public class TrieNode {
        char c;
        boolean leaf;
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        
        TrieNode(char c) { 
            this.c = c;
        }
        
        TrieNode() {}
    }
	
	// 
	/*HashSet<String> dict = new HashSet<String>();

    // Adds a word into the data structure.
    public void addWord(String word) {
        dict.add(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        for (String item : dict) {
        	if (word.length() != item.length())	continue;
        	for (int i = 0; i < word.length(); i++) {
        		if (word.charAt(i) != '.' && item.charAt(i) != word.charAt(i)) {
        			break;
        		}
        		if (i == word.length() - 1) {
        			return true;
        		}
        	}
        }
        return false;
    }*/
    
    public static void main(String[] args) {
    	WordDictionary w = new WordDictionary();
    	w.addWord("bad");
    	w.addWord("dad");
    	w.addWord("mad");
    	System.out.println(w.search("pad"));
    	System.out.println(w.search("bad"));
    	System.out.println(w.search(".ad"));
    	System.out.println(w.search("b.."));
    }
}
// http://blog.csdn.net/xudli/article/details/45840001