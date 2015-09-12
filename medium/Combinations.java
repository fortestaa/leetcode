package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 77 Combinations
 * https://leetcode.com/problems/combinations/
 * 
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * 
 * For example, If n = 4 and k = 2, a solution is:
 * [
 *  [2,4], 
 *  [3,4], 
 *  [2,3], 
 *  [1,2], 
 *  [1,3], 
 *  [1,4], 
 * ]
 */
public class Combinations {
    public List<List<Integer>> combine1(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k > n) {
        	return null;
        } else if (k == n) {
        	List<Integer> tmp = new ArrayList<Integer>();
        	for (int i = 1; i <= n; i++) {
        		tmp.add(i);
        	}
        	result.add(tmp);
        	return result;
        } else if (k == 1) {
        	for (int i = 1; i <= n; i++) {
        		List<Integer> tmp = new ArrayList<Integer>();
        		tmp.add(i);
        		result.add(tmp);
        	}
        	return result;
        }
        
        for (int i = 1; i <= n - k + 1; i++) {
        	List<Integer> tmp = new ArrayList<Integer>();
        	tmp.add(i);
        	result.add(tmp);
        }
        combine(n, k, result);
        return result;
    }   
    private void combine(int n, int k, List<List<Integer>> result) {
    	List<List<Integer>> prevResult = new ArrayList<List<Integer>>();
    	prevResult.addAll(result);
    	if (result.get(0).size() == k)	return;
    	result.clear();
    	for(List<Integer> one : prevResult) {
    		for (int i = 1; i <= n; i++) {
    			if (i > one.get(one.size() - 1)) {
    				List<Integer> tmp = new ArrayList<Integer>();
    				tmp.addAll(one);
    				tmp.add(i);
    				result.add(tmp);
    			}
    		}
    	}
    	combine(n, k, result);
    }
    

    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if (n <= 0 || n < k)
    		return result;
    	
    	List<Integer> item = new ArrayList<Integer>();
    	dfs(n, k, 1, item, result);
    	return result;
    }
    private void dfs(int n, int k, int start, List<Integer> item, List<List<Integer>> res) {
    	if (item.size() == k) {
    		res.add(new ArrayList<Integer>(item));
    		return;
    	}
    	
    	for (int i = start; i <= n; i++) {
    		item.add(i);
    		dfs(n, k, i + 1, item, res);
    		item.remove(item.size() - 1);
    	}
    }
}
// http://www.programcreek.com/2014/03/leetcode-combinations-java/