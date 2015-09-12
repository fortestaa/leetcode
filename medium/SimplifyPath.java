package medium;

import java.util.LinkedList;

public class SimplifyPath {
    public String simplifyPath(String path) {
    	LinkedList<String> stack = new LinkedList<String>();
    	String[] pathsplit = path.split("/");
    	for (String p : pathsplit) {
    		if (p.equals("..") && !stack.isEmpty()) {	// stack pop
    			stack.removeLast();
    		} else if (p.length() != 0 && !p.equals(".") && !p.equals("..")) {
    			stack.addLast(p);
    		}
    	}
    	StringBuilder sb = new StringBuilder();
    	if (stack.isEmpty())	return "/";
    	for (String p : stack) {
    		sb.append("/");
    		sb.append(p);
    	}
    	return sb.toString();
    }
    
    /*public String simplifyPath0(String path) {
        if (path == "/")    return "/";
    	int start = 0, end = path.length();
    	for (int i = 0; i < end; i++) {
    		if (path.charAt(i) == '/' && i < end - 1) {
    			start = i;
    		}
    	}
    	return path.substring(start, end - 1);
    }*/
    
    public static void main(String[] args) {
    	SimplifyPath s = new SimplifyPath();
    	System.out.println(s.simplifyPath("/"));
    	//System.out.println(s.simplifyPath0("/"));
    	System.out.println(s.simplifyPath("/home"));
    	System.out.println(s.simplifyPath("/a/./b/../../c/"));
    }
}
//http://zjalgorithm.blogspot.com/2014/11/leetcode-simplify-path-java.html