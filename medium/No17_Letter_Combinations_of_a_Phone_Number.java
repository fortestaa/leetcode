package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * 
 * Given a digit string, return all possible letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * Input:Digit string "23" 
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]. 
 * Note: Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class No17_Letter_Combinations_of_a_Phone_Number {
    public List<String> letterCombinations(String digits) {
    	List<String> rst = new ArrayList<String>();
    	if (digits == null || digits.length() == 0)	return rst;
    	
    	HashMap<Integer, String> map = new HashMap<Integer, String>();
    	map.put(2, "abc");
    	map.put(3, "def");
    	map.put(4, "ghi");
    	map.put(5, "jkl");
    	map.put(6, "mno");
    	map.put(7, "pqrs");
    	map.put(8, "tuv");
    	map.put(9, "wxyz");
    	map.put(0, "");
    	
    	List<Character> temp = new ArrayList<Character>();
    	getString(digits, temp, rst, map);
    	return rst;
    }
    
    private void getString(String digits, List<Character> temp, List<String> rst, HashMap<Integer, String> map) {
    	if (digits.length() == 0) {
    		char[] arr = new char[temp.size()];
    		for (int i = 0; i < temp.size(); i++) {
    			arr[i] = temp.get(i);
    		}
    		rst.add(String.valueOf(arr));
    		return;
    	}
    	
    	int curr = Integer.valueOf(digits.substring(0, 1));
    	String letters = map.get(curr);
    	for (int i = 0; i < letters.length(); i++) {
    		temp.add(letters.charAt(i));
    		getString(digits.substring(1), temp, rst, map);
    		temp.remove(temp.size() - 1);
    	}
    }
    
    public static void main(String[] args) {
    	Letter_Combinations_of_a_Phone_Number l = new Letter_Combinations_of_a_Phone_Number();
    	List<String> rst = l.letterCombinations("23");
    	for (int i = 0; i < rst.size(); i++) {
    		System.out.println(rst.get(i));
    	}
    }
}
// http://www.programcreek.com/2014/04/leetcode-letter-combinations-of-a-phone-number-java/
