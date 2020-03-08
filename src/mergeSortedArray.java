import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */
public class mergeSortedArray {
    public static void main(String[] args) {
        int nums1[] = {0};
        int nums2[] = {1};
        for (int i : merge(nums1, 0, nums2, 1)) {
            System.out.println(i);
        }
    }

    /**
     * 默认使用插入排序尝试
     * 最外圈的i循环是取需要插入的nums2数组
     * j循环是用于比较nums2在1中插入的位置，从后往前，所以是倒序
     * 只有插入的数据小于原始数据才需要交换操作。
     */
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
            return nums1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = (m - 1) + i; j >= 0; j--) {
                if (nums2[i] < nums1[j]) {
                    nums1[j + 1] = nums1[j];
                    nums1[j] = nums2[i];
                } else {
                    nums1[j + 1] = nums2[i];
                    break;
                }
            }
        }
        return nums1;
    }

    /**
     * 最朴素的解法就是将两个数组合并之后再排序。该算法只需要一行(Java是2行)，时间复杂度较差，为O((n + m)\log(n + m))O((n+m)log(n+m))。这是由于这种方法没有利用两个数组本身已经有序这一点。
     * 使用系统自带方法
     * 复杂度分析
     * <p>
     * 时间复杂度 : O((n + m)log(n + m))。
     * 空间复杂度 : O(1)。
     */
    public static int[] mergeSystem(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
        return nums1;
    }
}
