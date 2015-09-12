package easy;

/**
 * 38 Count and Say
 * https://leetcode.com/problems/count-and-say/
 * 
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11. 
 * 11 is read off as "two 1s" or 21. 
 * 21 is read off as "one 2, then one 1" or 1211. 
 * 
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 */
public class Count_and_Say {
    public String countAndSay(int n) {
        String res = "1";
        while (--n > 0) {
            StringBuilder sb = new StringBuilder();
            char[] prev = res.toCharArray();
            for (int i = 0; i < prev.length; i++) {
                int count = 1;
                while (i + 1 < prev.length && prev[i] == prev[i + 1]) {
                    count++;
                    i++;
                }
                sb.append(count).append(prev[i]);
            }
            res = sb.toString();
        }
        return res;
    }
}
