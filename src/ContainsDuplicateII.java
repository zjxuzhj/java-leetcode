import java.util.HashSet;
import java.util.Set;

/**
 * 219. 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */
public class ContainsDuplicateII {
    /**
     * 用hash表维持k的窗口
     * 执行用时 : 11 ms, 在所有 Java 提交中击败了 57.17% 的用户 内存消耗 : 43 MB , 在所有 Java 提交中击败了 20.00% 的用户
     */
    public static boolean containsNearbyDuplicateHash(int[] nums, int k) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i]))
                return true;
            hashSet.add(nums[i]);
            if (hashSet.size() > k) {
                hashSet.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = Math.max(i - k, 0); j < i; ++j) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicateHash(nums, 2));
    }
}
