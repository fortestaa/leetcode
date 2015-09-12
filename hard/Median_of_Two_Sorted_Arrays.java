package hard;

/**
 * 4	Median of Two Sorted Arrays
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
public class Median_of_Two_Sorted_Arrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        if (total % 2 != 0) {
            return findKth(nums1, 0, m - 1, nums2, 0, n - 1, total / 2 + 1);
        } else {
            double a = findKth(nums1, 0, m - 1, nums2, 0, n - 1, total / 2);
            double b = findKth(nums1, 0, m - 1, nums2, 0, n - 1, total / 2 + 1);
            return (a + b) / 2;
        }
    }
    
    private double findKth(int[] nums1, int astart, int aend, int[] nums2, int bstart, int bend, int k) {
        int m = aend - astart + 1;
        int n = bend - bstart + 1;
        
        if (m > n)  return findKth(nums2, bstart, bend, nums1, astart, aend, k);
        if (m == 0) return nums2[k - 1];
        if (k == 1) return Math.min(nums1[astart], nums2[bstart]);
        
        int parta = Math.min(k / 2, m);
        int partb = k - parta;
        if (nums1[astart + parta - 1] < nums2[bstart + partb - 1]) {
            return findKth(nums1, astart + parta, aend, nums2, bstart, bend, k - parta);
        } else if (nums1[astart + parta - 1] > nums2[bstart + partb - 1]) {
            return findKth(nums1, astart, aend, nums2, bstart + partb, bend, k - partb);
        } else {
            return nums1[astart + parta - 1];
        }
    }
}
// http://www.cnblogs.com/springfor/p/3861890.html
// http://www.geeksforgeeks.org/median-of-two-sorted-arrays/