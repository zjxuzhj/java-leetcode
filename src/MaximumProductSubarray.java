/**
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class MaximumProductSubarray {
    /**
     * 涉及到子串问题的基本上都可以用dp来做，你没看出来上面是dp的思想，是因为它不需要用一个数组来存储状态
     * 执行用时 : 4 ms , 在所有 Java 提交中击败了 16.83% 的用户 内存消耗 : 39.8 MB , 在所有 Java 提交中击败了 6.67% 的用户
     */
    public static int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int ans = nums[0];
        //两个mDP分别定义以i结尾的子数组的最大积与最小积
        int[] maxDP = new int[nums.length];
        int[] minDP = new int[nums.length];
        //初始化DP
        maxDP[0] = nums[0];
        minDP[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            //最大积的可能情况有：元素i自己本身，上一个最大积与i元素累乘，上一个最小积与i元素累乘；
            //与i元素自己进行比较是为了处理i元素之前全都是0的情况；
            maxDP[i] = Math.max(nums[i], Math.max(maxDP[i - 1] * nums[i], minDP[i - 1] * nums[i]));
            minDP[i] = Math.min(nums[i], Math.min(maxDP[i - 1] * nums[i], minDP[i - 1] * nums[i]));
            //记录ans；
            ans = Math.max(ans, maxDP[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }
}
