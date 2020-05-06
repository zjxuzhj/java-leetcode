/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement {

    /**
     * 冒泡排序 超时
     * 插排 通过
     * 执行用时 : 130 ms , 在所有 Java 提交中击败了 5.13% 的用户 内存消耗 : 43.4 MB , 在所有 Java 提交中击败了 5.71% 的用户
     */
    public static int majorityElement(int[] nums) {
//        for (int i = 0; i < nums.length-1; i++) {
//            for (int j = 0; j < nums.length - i - 1; j++) {
//               if(nums[j]>nums[j+1]){
//                   int temp=nums[j+1];
//                   nums[j + 1] = nums[j];
//                   nums[j] = temp;
//               }
//            }
//        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            //内层循环比较 i 与前边所有元素值，如果 j 索引所指的值小于 j- 1 则交换两者的位置
            for(int j = i; j > 0 && nums[j-1] > nums[j]; j--){
                if(nums[j-1]>nums[j]) {
                    int temp = nums[j-1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums[nums.length / 2];
    }

    /**
     * 摩尔投票法
     * 如果我们把众数记为 +1，把其他数记为 -1，将它们全部加起来，显然和大于 0，从结果本身我们可以看出众数比其他数多。
     *
     * 候选人(cand_num)初始化为nums[0]，票数count初始化为1。
     * 当遇到与cand_num相同的数，则票数count = count + 1，否则票数count = count - 1。
     * 当票数count为0时，更换候选人，并将票数count重置为1。
     * 遍历完数组后，cand_num即为最终答案。
     *
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 83.29% 的用户 内存消耗 : 43.7 MB , 在所有 Java 提交中击败了 5.71% 的用户
     */
    public static int majorityElementNormal(int[] nums) {
        int cand_num = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cand_num == nums[i]) {
                count++;
            } else if (--count == 0) {
                cand_num = nums[i];
                count = 1;
            }
        }
        return cand_num;
    }

    public static void main(String[] args) {
        int nums[] = {2,2,1,1,1,2,2};
        System.out.println(majorityElementNormal(nums));
    }
}
