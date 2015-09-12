package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 212 Word Search II
 * 
 * Given a 2D board and a list of words from the dictionary, find all words in
 * the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once in a word.
 * 
 * For example, Given words = ["oath","pea","eat","rain"] and board =
 * [
 *  ['o','a','a','n'], 
 *  ['e','t','a','e'], 
 *  ['i','h','k','r'], 
 *  ['i','f','l','v']
 * ] 
 * Return ["eat","oath"]. 
 * 
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 * 
 * click to show hint.
 * 
 * You would need to optimize your backtracking to pass the larger test. Could
 * you stop backtracking earlier?
 * 
 * If the current candidate does not exist in all words' prefix, you could stop
 * backtracking immediately. What kind of data structure could answer such query
 * efficiently? Does a hash table work? Why or why not? How about a Trie? If you
 * would like to learn how to implement a basic trie, please work on this
 * problem: Implement Trie (Prefix Tree) first.
 */
public class WordSearch2 {
	public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<String>();
        if (board == null || words == null || board.length == 0 || words.length == 0)  return new ArrayList<String>(res);
        
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(board, visited, trie, i, j, new StringBuilder(), res);
            }
        }
        return new ArrayList<String>(res);
    }

	private void search(char[][] board, boolean[][] visited, Trie trie, int i,
			int j, StringBuilder sb, Set<String> res) {
		if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1
				|| visited[i][j])
			return;

		sb.append(board[i][j]);
		visited[i][j] = true;
		String s = sb.toString();
		if (trie.startsWith(s)) {
			if (trie.search(s))
				res.add(s);
			search(board, visited, trie, i - 1, j, sb, res);
			search(board, visited, trie, i + 1, j, sb, res);
			search(board, visited, trie, i, j - 1, sb, res);
			search(board, visited, trie, i, j + 1, sb, res);
		}
		sb.deleteCharAt(sb.length() - 1);
		visited[i][j] = false;
	}

	class TrieNode {
		char c;
		boolean leaf;
		HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();

		public TrieNode(char c) {
			this.c = c;
		}

		public TrieNode() {
		}
	}

	class Trie {
		TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			Map<Character, TrieNode> children = root.children;
			TrieNode t = null;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (children.containsKey(c)) {
					t = children.get(c);
				} else {
					t = new TrieNode(c);
					children.put(c, t);
				}
				children = t.children;
				if (i == word.length() - 1)
					t.leaf = true;
			}
		}

		public boolean search(String word) {
			TrieNode t = searchNode(word);
			return t != null && t.leaf;
		}

		public boolean startsWith(String prefix) {
			return searchNode(prefix) != null;
		}

		private TrieNode searchNode(String word) {
			Map<Character, TrieNode> children = root.children;
			TrieNode t = null;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (!children.containsKey(c))
					return null;
				t = children.get(c);
				children = t.children;
			}
			return t;
		}
	}
}
// http://blog.csdn.net/xudli/article/details/45864915