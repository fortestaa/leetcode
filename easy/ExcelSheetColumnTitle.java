package easy;

/**
 * 168 Excel Sheet Column Title
 * https://leetcode.com/problems/excel-sheet-column-title/
 * 
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * 
 * For example:
 * 1 -> A 
 * 2 -> B 
 * 3 -> C 
 * ... 
 * 26 -> Z 
 * 27 -> AA 
 * 28 -> AB
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        if (n <= 0) return "";
        
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            int r = n % 26;
            sb.insert(0, (char)('A' + r));
            n = n / 26;
        }
        return sb.toString();
    }
}
// The key is n--. The minimum in 26-bit number is mapped to 1, not 0.
// http://www.programcreek.com/2014/03/leetcode-excel-sheet-column-title-java/