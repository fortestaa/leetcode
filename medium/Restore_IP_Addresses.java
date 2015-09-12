package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 93	Restore IP Addresses
 * https://leetcode.com/problems/restore-ip-addresses/
 * 
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class Restore_IP_Addresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() > 12)   return result;
        String temp = "";
        dfs(s, 0, temp, result);
        return result;
    }
    
    private boolean dfs(String input, int number, String ipAddress, List<String> result) {
        if (input.length() == 0)    return false;
        if (number == 3) {
            int addressNumber = Integer.parseInt(input);
            if (input.charAt(0) == '0') {
                if (!(input.length() == 1 && addressNumber == 0)) {
                    return false;
                }
            }
            if (addressNumber <= 255) {
                ipAddress = ipAddress + input;
                result.add(ipAddress);
                return true;
            } else {
                return false;
            }
        } else {
            if (input.length() >= 1) {
                dfs(input.substring(1), number + 1, ipAddress + input.substring(0, 1) + ".", result);
            }
            
            if (input.length() >= 2 && input.charAt(0) != '0') {
                dfs(input.substring(2), number + 1, ipAddress + input.substring(0, 2) + ".", result);
            }
            
            if (input.length() >= 3 && input.charAt(0) != '0') {
                int addressNumber = Integer.parseInt(input.substring(0, 3));
                if (addressNumber <= 255) {
                    dfs(input.substring(3), number + 1, ipAddress + input.substring(0, 3) + ".", result);
                }
            }
        }
        return true;
    }
}
// http://blog.csdn.net/worldwindjp/article/details/21336107