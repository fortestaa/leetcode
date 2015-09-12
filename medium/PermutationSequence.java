package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 60 Permutation Sequence
 * https://leetcode.com/problems/permutation-sequence/
 * 
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, We get the following sequence (ie, for n = 3): 
 * "123" "132" "213" "231" "312" "321" 
 * 
 * Given n and k, return the kth permutation sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
    	k--;
    	
    	List<Integer> numList = new ArrayList<Integer>();
    	for (int i = 1; i <= n; i++) {
    		numList.add(i);
    	}
    	
    	int factorial = 1;
    	for (int i = 2; i < n; i++) {
    		factorial *= i;
    	}
    	
    	StringBuilder res = new StringBuilder();
    	int times = n - 1;
    	while (times >= 0) {
    		int indexInList = k / factorial;
    		res.append(numList.get(indexInList));
    		numList.remove(indexInList);
    		
    		k = k % factorial;
    		if (times != 0)
    			factorial = factorial / times;
    		
    		times--;
    	}
    	return res.toString();
    }
}
// http://www.cnblogs.com/springfor/p/3896201.html