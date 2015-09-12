package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20 Valid Parentheses https://leetcode.com/problems/valid-parentheses/
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
    private static final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('(', ')');
        put('[', ']');
        put('{', '}');
     }};
     
     public boolean isValid(String s) {
         Stack<Character> stack = new Stack<>();
         for (char c : s.toCharArray()) {
             if (map.containsKey(c)) {
                 stack.push(c);
             } else if (stack.isEmpty() || map.get(stack.pop()) != c) {
                 return false;
             }
         }
         return stack.isEmpty();
     }
}
