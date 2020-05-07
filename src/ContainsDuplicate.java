import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 *
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 *
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 *
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class ContainsDuplicate {

    /**
     * 使用hash表存放
     *
     * 执行用时 : 9 ms , 在所有 Java 提交中击败了 61.01% 的用户 内存消耗 : 46.3 MB , 在所有 Java 提交中击败了 6.98% 的用户
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }else{
                set.add(num);
            }
        }
        return false;
    }

    /**
     * 预排序后比较
     *
     * 执行用时 : 42 ms , 在所有 Java 提交中击败了 5.02%的用户内存消耗 : 43.4 MB , 在所有 Java 提交中击败了 39.53% 的用户
     */
    public static boolean containsDuplicateNormal(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            //内层循环比较 i 与前边所有元素值，如果 j 索引所指的值小于 j- 1 则交换两者的位置
            for (int j = i; j > 0 && nums[j - 1] > nums[j]; j--) {
                if (nums[j - 1] > nums[j]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (i + 1 < n && nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,1};
        System.out.println(containsDuplicateNormal(nums));
    }
}
