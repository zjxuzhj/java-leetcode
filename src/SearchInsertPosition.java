/**
 * 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int nums[] = {1, 3, 5, 6};
        System.out.println(searchInsertNorMal(nums, 7));
    }

    public static int searchInsert(int[] nums, int target) {
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] >= target) {
                return j;
            }
        }
        return nums.length;
    }

    /**
     * 二分查找
     *
     * 如果该题目暴力解决的话需要 O(n) 的时间复杂度，但是如果二分的话则可以降低到 O(logn) 的时间复杂度
     *
     * 整体思路和普通的二分查找几乎没有区别，先设定左侧下标 left 和右侧下标 right，再计算中间下标 mid
     * 每次根据 nums[mid] 和 target 之间的大小进行判断，相等则直接返回下标，nums[mid] < target 则 left 右移，nums[mid] > target 则 right 左移
     * 查找结束如果没有相等值则返回 left，该值为插入位置
     *
     * 时间复杂度：O(logn)
     * 二分查找的思路不难理解，但是边界条件容易出错，比如 循环结束条件中 left 和 right 的关系，更新 left 和 right 位置时要不要加 1 减 1。
     */
    public static int searchInsertNorMal(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
