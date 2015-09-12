package easy;

import java.util.LinkedList;

/**
 * 71 Simplify Path
 * https://leetcode.com/problems/simplify-path/
 * 
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example, 
 * path = "/home/", => "/home" 
 * path = "/a/./b/../../c/", => "/c"
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<String>();
        String[] pathsplit = path.split("/");
        for (String s : pathsplit) {
            if (s.equals("..") && !stack.isEmpty()) {
                stack.removeLast();
            } else if (s.length() != 0 && !s.equals(".") && !s.equals("..")) {
                stack.addLast(s);
            }
        }
        if (stack.isEmpty())    return "/";
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/");
            sb.append(s);
        }
        return sb.toString();
    }
}