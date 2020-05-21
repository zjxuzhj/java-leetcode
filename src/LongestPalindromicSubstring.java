/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class LongestPalindromicSubstring {
    public static boolean isPalindrome(String s) {
        //正则过滤除数字字母外所有字符
        if ("".equals(s)) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (right > left) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    /**
     * 暴力法虽然看着很朴实，其实对于相当一部分题目来说都是足够解题的，关键在与内外循环的提前停止
     * 外循环是逐步变短，有值就直接return
     * 内循环是没必要从最小值开始，直接从最大值做索引
     * 执行用时 : 1413 ms , 在所有 Java 提交中击败了 5.00% 的用户 内存消耗 : 39.8 MB , 在所有 Java 提交中击败了 15.18% 的用户
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 0;
        String maxLenStr = s.charAt(0) + "", substring;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                substring = s.substring(i, j + 1);
                if (maxLen < substring.length() && isPalindrome(substring)) {
                    maxLenStr = substring;
                    maxLen = substring.length();
                }
            }
        }
        return maxLenStr;
    }

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }
}
