/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class climbingStairs {
    public static void main(String[] args) {
//        System.out.println(climbStairs(0, 5));
        System.out.println(climbStairsBP(5));
    }

    /**
     * 使用暴力法，n阶到楼顶，每次爬1或2阶，使用轮询每次调用，最后0或1结束
     *
     * @param n
     * @return
     */
    public static int climbStairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climbStairs(i + 1, n) + climbStairs(i + 2, n);
    }

    /**
     * 使用动态规划
     * 不难发现，这个问题可以被分解为一些包含最优子结构的子问题，即它的最优解可以从其子问题的最优解来有效地构建，我们可以使用动态规划来解决这一问题。
     * <p>
     * 第 i 阶可以由以下两种方法得到：
     * <p>
     * 在第 (i-1) 阶后向上爬 1 阶。
     * <p>
     * 在第 (i-2) 阶后向上爬 2 阶。
     * <p>
     * 所以到达第 i 阶的方法总数就是到第 (i-1) 阶和第 (i-2) 阶的方法数之和。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * <p>
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户内存消耗 : 36.5 MB, 在所有 Java 提交中击败了 5.09% 的用户
     * <p>
     * 复杂度分析
     * <p>
     * 时间复杂度：O(n)，单循环到 n 。
     * <p>
     * 空间复杂度：O(n)，dp 数组用了 n 的空间。
     */
    public static int climbStairsDP(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 使用斐波那契数列，就是空间节省了，时间还是需要单循环n
     *
     * @param n
     * @return
     */
    public static int climbStairsBP(int n) {
        if (n == 1) {
            return 1;
        }
        int dp1 = 1, dp2 = 2, dp3;
        for (int i = 3; i < n + 1; i++) {
            dp3 = dp1 + dp2;
            dp1 = dp2;
            dp2 = dp3;
        }
        return dp2;
    }

}
