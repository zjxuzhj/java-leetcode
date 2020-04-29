import java.util.Arrays;

/**
 * 167. 两数之和 II - 输入有序数组
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class TwoSumIiInputArrayIsSorted {

    /**
     * 执行用时 : 306 ms , 在所有 Java 提交中击败了 5.03% 的用户内存消耗 : 40.2 MB , 在所有 Java 提交中击败了 6.67% 的用户
     */
    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return null;
    }

    /**
     * 头尾指针
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 97.86% 的用户 内存消耗 : 40.1 MB , 在所有 Java 提交中击败了 6.67% 的用户
     */
    public static int[] twoSumDouble(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (right > left) {
            if (numbers[left] + numbers[right] < target) {
                left++;
            } else if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSumDouble(numbers, 13)));
    }
}
