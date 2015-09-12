package medium;

/**
 * 215	Kth Largest Element in an Array
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * 
 * Find the kth largest element in an unsorted array. 
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * 
 * For example, Given [3,2,1,5,6,4] and k = 2, return 5.
 * Note: You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class Kth_Largest_Element_in_an_Array {
    public int findKthLargest0(int[] nums, int k) {
        int L = 0, R = nums.length - 1;
        while (L < R) {
            int left = L, right = R;
            int key = nums[left];
            while (left < right) {
                while (left < right && nums[right] < key)   --right;
                nums[left] = nums[right];
                while (left < right && nums[left] >= key)   ++left;
                nums[right] = nums[left];
            }
            nums[left] = key;
            if (left == k - 1)  return nums[k - 1];
            else if (left > k - 1)  R = left - 1;
            else    L = left + 1;
        }
        return nums[k - 1];
    }
    // http://www.cnblogs.com/easonliu/p/4523941.html

    
    public int findKthLargest(int[] nums, int k) {
        return findK(nums, nums.length - k, 0, nums.length - 1);
    }
    
    private int findK(int[] nums, int k, int i, int j) {
        if (i >= j) return nums[i];
        int m = partition(nums, i, j);
        if (m == k) {
            return nums[m];
        } else if (m < k) {
            return findK(nums, k, m + 1, j);
        } else {
            return findK(nums, k, i, m - 1);
        }
    }
    
    private int partition(int[] nums, int i, int j) {
        int x = nums[i];
        int m = i;
        int n = i + 1;
        while (n <= j) {
            if (nums[n] < x) {
                swap(nums, ++m, n);
            }
            n++;
        }
        swap(nums, i, m);
        return m;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    
    public static void main(String[] args) {
    	Kth_Largest_Element_in_an_Array s = new Kth_Largest_Element_in_an_Array();
    	int nums[] = {2, 1};
    	System.out.println(s.findKthLargest(nums, 1));
    }
}
// http://blog.csdn.net/xudli/article/details/46224669