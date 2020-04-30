/**
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class SingleNumber {
    /**
     * 使用异或运算符 ^  相同为0，不同为1. 异或同一个数两次，原数不变。
     *
     * 执行用时 : 1 ms, 在所有 Java 提交中击败了99.74% 的用户 内存消耗 :40.7 MB , 在所有 Java 提交中击败了 5.71% 的用户
     */
    public static int singleNumber(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 2, 1};
        System.out.println(singleNumber(numbers));
    }
}
