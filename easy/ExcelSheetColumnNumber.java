package easy;

/**
 * 171 Excel Sheet Column Number
 * https://leetcode.com/problems/excel-sheet-column-number/
 * 
 * Related to question Excel Sheet Column Title
 * 
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 * For example:
 * A -> 1 
 * B -> 2 
 * C -> 3 
 * ... 
 * Z -> 26 
 * AA -> 27 
 * AB -> 28
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int result = 0;
		for (char c : s.toCharArray()) {
			int i = c - 'A' + 1;
			result = result * 26 + i;
		}
		return result;
    }
}