package medium;

import java.util.Stack;

/**
 * 224	Basic Calculator
 * https://leetcode.com/problems/basic-calculator/
 * 
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 * 
 * You may assume that the given expression is always valid.
 * 
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * Note: Do not use the eval built-in library function.
 */
public class BasicCalculator {
	public int calculate(String s) {
		if (s == null || s.length() == 0)	return 0;

		Stack<Integer> stack = new Stack<Integer>();
		int res = 0;
		int sign = 1;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				int cur = c - '0';
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					cur = cur * 10 + s.charAt(++i) - '0';
				}
				res += sign * cur;
			} else if (c == '+') {
				sign = 1;
			} else if (c == '-') {
				sign = -1;
			} else if (c == '(') {
				stack.push(res);
				res = 0;
				stack.push(sign);
				sign = 1;
			} else if (c == ')') {
				res = stack.pop() * res + stack.pop();
				sign = 1;
			}
		}
		return res;
	}
}
// http://www.cnblogs.com/lailailai/p/4565007.html
// http://blog.csdn.net/xudli/article/details/46554835