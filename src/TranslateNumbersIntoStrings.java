/**
 * 面试题46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * 提示：
 *
 * 0 <= num < 231
 */
public class TranslateNumbersIntoStrings {
    /**
     * 递归竟然有双百，牛皮
     * 执行用时 : 0 ms, 在所有 Java 提交中击败了 100.00% 的用户 内存消耗 :36.7 MB, 在所有 Java 提交中击败了 100.00% 的用户
     */
    public static int translateNum(int num) {
        if (num < 9) {
            return 1;
        }
        if (num % 100 >= 26 || num % 100 <= 9) {
            return translateNum(num / 10);
        } else {
            return translateNum(num / 10) + translateNum(num / 100);
        }
    }

    public static void main(String[] args) {
        System.out.println(translateNum(12258));
    }
}
