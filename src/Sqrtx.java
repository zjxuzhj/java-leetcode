/**
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class Sqrtx {
    /**
     * 二分查找
     *
     * 执行用时 :2 ms , 在所有 Java 提交中击败了 63.44% 的用户 内存消耗 : 36.6 MB , 在所有 Java 提交中击败了 5.55% 的用户
     */
    public static int mySqrt(int x) {
        long left = 1, right = x, mid;
        if (x == 0) return 0;
        if (x == 1) return 1;
        while (left < right) {
            mid = (left + right) / 2;
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid < x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return (int)left - 1;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }
}
