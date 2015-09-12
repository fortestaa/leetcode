package medium;

/**
 * 260	Single Number III
 * https://leetcode.com/problems/single-number-iii/
 * 
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * 
 * For example: Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * 
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
public class SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        diff &= -diff;
        
        int[] rets = {0, 0};
        for (int num : nums) {
            if ((num & diff) == 0) {
                rets[0] ^= num;
            } else {
                rets[1] ^= num;
            }
        }
        return rets;
    }
}
/*
 * 记只出现一次的两个数字分别为a与b
 * 首先计算数组中所有数字的异或（diff），因为除了a和b两个数字其他每个数字都出现了两次——那么两两异或结果为0，
 * 所以diff会是a,b的异或结果(a^b)
 * 
 * 接着算出最后一个1出现的位置并且记下来
 * 令lowbit = diff & -diff，lowbit的含义为diff从低位向高位，第一个非0位所对应的数字（负数的表示方法参见1）
 * 比如假设diff＝6（二进制：0110），那么－diff用二进制表示为1010，所以lowbit＝0010（2）
 * －－－－－－为什么diff & -diff的结果一定会是diff从低位向高位，第一个非0位所对应的数字（其他位都是0）呢？这个也是可以证明的：－－－－－－
 * -diff是diff除符号位各位取反加1的，我们可以分别从lowbit两边分析：
 * lowbit右边，显然根据设定diff在这右边都是0，所以取反之后变为1，最后加1之后，-diff还是会变成0，所以diff&-diff在这右边各位都取0的
 * lowbit这一位，根据设定diff在这一位会取1，所以取反之后变为0，再加上lowbit右边各位加上1后所进的“1”，-diff在这一位会变为1
 * lowbit左边，因为负数是原码取反加1的，而在lowbit这一位开始往高位走，就不会再有进位了（加的1在lowbit这里已经把0变为1，不会产生新的进位），所以diff和-diff在这左边的范围内是互为反码（取反操作），那么diff&-diff各位取0
 * 所以diff & -diff的结果就是000000..010..0格式的，其中1会是diff中也存在的1
 * 
 * 因为lowbit是diff从低位到高位第一个非0位所对应的数字，那么说明a和b必然在这个位上取不同的值（异或运算的性质：“同0异1”）
 * 所以a & lowbit 和 b & lowbit一定结果不同
 * 所以最后可以把数组中的数字分成2组，一组&lowbit＝0，一组结果是1，而a,b分别落入两组之中
 * 最后因为两组的其他数字都会出现2次，所以分别异或两组数字，会得到这两个数（a，b）
 * 
 * 1.负数的二进制表示方法  http://weihe6666.iteye.com/blog/1190033
 * 原码：一个正数，按照绝对值大小转换成的二进制数；一个负数按照绝对值大小转换成的二进制数，然后最高位补1，称为原码。 
 * 反码：正数的反码与原码相同，负数的反码为对该数的原码除符号位外各位取反。
 * 		取反操作指：原为1，得0；原为0，得1。（1变0; 0变1） 
 * 补码：正数的补码与原码相同，负数的补码为对该数的原码除符号位外各位取反，然后在最后一位加1. 
 * 例如：来看整数-1在计算机中如何表示
 * 		1、先取-1的原码：10000000 00000000 00000000 00000001 
 * 		2、得反码：     11111111 11111111 11111111 11111110（除符号位按位取反） 
 * 		3、得补码：     11111111 11111111 11111111 11111111 
 * 		可见，－1在计算机里用二进制表达就是全1。16进制为：0xFFFFFF 
 * 
 * 主要知识点： 
 * 正数的反码和补码都与原码相同。 
 * 而负数的反码为对该数的原码除符号位外各位取反。 
 * 负数的补码为对该数的原码除符号位外各位取反，然后在最后一位加1 
 * 
 * 下面是书上原文： 
 * 原码表示法规定：用符号位和数值表示带符号数，正数的符号位用“0”表示，负数的符号位用“1”表示，数值部分用二进制形式表示。 
 * 反码表示法规定：正数的反码与原码相同，负数的反码为对该数的原码除符号位外各位取反。 
 * 补码表示法规定：正数的补码与原码相同，负数的补码为对该数的原码除符号位外各位取反，然后在最后一位加1.
 * 正零和负零的补码相同，[+0]补=[-0]补=0000 0000B
 */
// http://bookshadow.com/weblog/2015/08/17/leetcode-single-number-iii/
// https://leetcode.com/discuss/52351/c-o-n-time-o-1-space-9-line-solution-with-detail-explanation
// http://blog.csdn.net/richard_rufeng/article/details/46974079