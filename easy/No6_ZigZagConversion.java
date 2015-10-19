package easy;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
(you may want to display this pattern in a fixed font for better legibility)
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/
public class No6_ZigZagConversion {
    public String convert(String s, int numRows) {
        StringBuffer[] sb = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++)   sb[i] = new StringBuffer();
        int len = s.length();
        int i = 0;
        while (i < len) {
            for (int j = 0; j < numRows && i < len; j++) {
                sb[j].append(s.charAt(i++));
            }
            for (int j = numRows - 2; j > 0 && i < len; j--) {
                sb[j].append(s.charAt(i++));
            }
        }
        for (int k = 1; k < numRows; k++)   sb[0].append(sb[k]);
        return sb[0].toString();
    }
}
