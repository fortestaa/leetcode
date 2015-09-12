package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 241	Different Ways to Add Parentheses
 * https://leetcode.com/problems/different-ways-to-add-parentheses/
 * 
 * Given a string of numbers and operators, 
 * return all possible results from computing all the different possible ways to group numbers and operators. 
 * The valid operators are +, - and *.
 * 
 * Example 1
 * Input: "2-1-1".
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Output: [0, 2]
 * 
 * Example 2
 * Input: "2*3-4*5"
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * Output: [-34, -14, -10, -10, 10]
 */
public class Different_Ways_to_Add_Parentheses { 
    List<Integer> numbers = new LinkedList<>();
    List<Character> opraters = new ArrayList<>();
    
    public List<Integer> diffWaysToCompute(String input) {
        StringBuilder num = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if ('0' <= c && c <= '9') {
                num.append(c);
            } else {
                numbers.add(Integer.parseInt(num.toString()));
                opraters.add(c);
                num = new StringBuilder();
            }
        }
        numbers.add(Integer.parseInt(num.toString()));
        List<Integer> res = dfs(numbers, opraters);
        Collections.sort(res);
        return res;
    }
    
    private List<Integer> dfs(List<Integer> numbers, List<Character> opraters) {
        List<Integer> res = new ArrayList<Integer>();
        if (numbers.size() == 1) {
            res.add(numbers.get(0));
            return res;
        }
        
        for (int i = 0; i < opraters.size(); i++) {
            char c = opraters.get(i);
            List<Integer> leftRes = dfs(numbers.subList(0, i + 1), opraters.subList(0, i));
            List<Integer> rightRes = dfs(numbers.subList(i + 1, numbers.size()), opraters.subList(i + 1, opraters.size()));
            for (int left : leftRes) {
                for (int right : rightRes) {
                    res.add(opRes(left, right, c));
                }
            }
        }
        
        return res;
    }
    
    private int opRes(int a, int b, char op) {
        switch (op) {
            case '*':
                return a * b;
            case '+':
                return a + b;
        }
        return a - b;
    }

    public static void main(String[] args) {
    	Different_Ways_to_Add_Parentheses d = new Different_Ways_to_Add_Parentheses();
    	String input = "2-4";
    	System.out.println(d.diffWaysToCompute(input));
    }
}
// http://blog.csdn.net/guorudi/article/details/47113127