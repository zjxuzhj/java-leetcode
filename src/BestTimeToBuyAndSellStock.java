/**
 * 121. 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意：你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class BestTimeToBuyAndSellStock {

    /**
     * DP (dynamic programming)
     * 动态规划 前i天的最大收益 = max{前i-1天的最大收益=第i天的价格-前i-1天中的最小价格}
     *
     * “动态规划”用于多阶段最优化问题的求解。这里天数代表每个阶段，即一天一天看，设置为第一维。
     * 为了消除后效性（前面的状态确定下来以后不会因为后面状态而更改），将当天是否持股设置为第二维的状态。于是：
     *
     * 状态 dp[i][j] 表示：在索引为 i 的这一天，用户手上持股状态为 j 所获得的最大利润。

     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 99.06% 的用户 内存消耗 : 39.5 MB , 在所有 Java 提交中击败了 5.32% 的用户
     */
    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, max = 0;
        for (int price : prices) {
            if (min > price) {
                min = price;
            }
            if (max < price - min) {
                max = price - min;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int nums[] = {7,6,4,3,1};
        System.out.println(maxProfit(nums));
    }
}
