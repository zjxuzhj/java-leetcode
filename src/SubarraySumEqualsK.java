import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为K的子数组
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 */
public class SubarraySumEqualsK {

    /**
     * 枚举法
     * 执行用时 : 567 ms, 在所有 Java 提交中击败了 5.03%的用户内存消耗 : 40.8 MB , 在所有 Java 提交中击败了 7.69%的用户
     */
    public static int subarraySum(int[] nums, int k) {
        int l = nums.length, sum, count = 0;
        for (int i = 0; i < l; i++) {
            sum = 0;
            if(nums[i]==k){
                count++;
            }
            for (int j = i+1; j < l; j++) {
                sum += nums[j];
                if (sum+nums[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 前缀和
     * 构建前缀和数组，以快速计算区间和；
     * 假设区间 left ，right 。也就是这个范围的子数组的和为K。也就是l的前缀和+k=r的前缀和
     * 所以，循环一遍数组，如果当前位置前序和-k和其他位置的前序和相等，就加一
     *
     * 单纯前缀和双指针没区别
     */
    public static int subarraySumNormal(int[] nums, int k) {
        int l = nums.length, count = 0;
        int[] preSum = new int[l + 1];
        preSum[0] = 0;
        for (int i = 0; i < l; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        for (int i = 0; i < l; i++) {
            for (int j = i; j < l; j++) {
                if (preSum[j+1]-preSum[i]== k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 前缀+哈希表优化
     *
     * 把前序值存到哈希表中，使查询加快
     * 执行用时 : 22 ms , 在所有 Java 提交中击败了 68.49% 的用户 内存消耗 : 40.8 MB , 在所有 Java 提交中击败了 7.69% 的用户
     */
    public static int subarraySumNormalHash(int[] nums, int k) {
        // key：前缀和，value：key 对应的前缀和的个数
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        // 对于下标为 0 的元素，前缀和为 0，个数为 1
        preSumFreq.put(0, 1);

        int preSum = 0, count = 0;
        for (int num : nums) {
            preSum += num;

            // 先获得前缀和为 preSum - k 的个数，加到计数变量里
            if (preSumFreq.containsKey(preSum - k)) {
                count += preSumFreq.get(preSum - k);
            }

            // 然后维护 preSumFreq 的定义
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int nums[] = {1,1,1};
        System.out.println(subarraySumNormalHash(nums,2));
    }
}
