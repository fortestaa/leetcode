package easy;

/**
 * 88	Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/
 * 
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * 
 * Note: You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        int[] res = new int[m + n];
        int count = 0;
        while (i < m || j < n) {
        	int a = i < m ? nums1[i] : Integer.MAX_VALUE;
        	int b = j < n ? nums2[j] : Integer.MAX_VALUE;
        	if (a < b) {
        		res[count++] = a;
        		i++;
        	} else {
        		res[count++] = b;
        		j++;
        	}
        }
        for (int k = 0; k < m + n; k++) {
        	nums1[k] = res[k];
        }
    }
}
