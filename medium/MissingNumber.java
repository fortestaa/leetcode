package medium;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * 
 * For example, Given nums = [0, 1, 3] return 2.
 * 
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
        	sum += num;
        }
        int largest = nums.length;	//一共有nums.length+1个数，所以最大数是nums.length
        int total = largest * (largest + 1) / 2;	//0-largest各个数字之和
        return total - sum;
    }
    
    public static void main(String[] args) {
    	MissingNumber m = new MissingNumber();
    	int nums[] = {0, 1, 3};
    	System.out.println(m.missingNumber(nums));
    }
}
// http://stackoverflow.com/questions/2113795/quickest-way-to-find-missing-number-in-an-array-of-numbers