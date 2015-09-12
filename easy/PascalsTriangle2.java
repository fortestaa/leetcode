package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 119 Pascal's Triangle II
 * https://leetcode.com/problems/pascals-triangle-ii/
 * 
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3, Return [1,3,3,1].
 * 
 * Note: Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) { // repeat k times
            for (int j = i - 1; j >= 1; j--) { // do it backwards
                row.set(j, row.get(j - 1) + row.get(j));
            }
            row.add(1); // add 1 at the end
        }
        return row;
    }
}