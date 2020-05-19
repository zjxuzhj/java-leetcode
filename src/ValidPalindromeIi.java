/**
 * 680. 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 * 注意:
 *
 * 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 */
public class ValidPalindromeIi {
    static boolean isDel = false;  //记录删除的字符次数

    /**
     * 执行用时 :10 ms , 在所有 Java 提交中击败了 50.12% 的用户 内存消耗 : 40.5 MB , 在所有 Java 提交中击败了 6.67% 的用户
     */
    public static boolean validPalindrome(String s) {
        if ("".equals(s)) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (right > left) {
            if (s.charAt(left) != s.charAt(right)) {
                //不相等的话，若没有删除字符，则删除左边或右边的字符再判断；若删除过一次，则不是回文串
                if (!isDel) {
                    isDel = true;
                    return validPalindrome(s.substring(left, right)) || validPalindrome(s.substring(left + 1, right + 1));
                }
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "deeee";
        System.out.println(validPalindrome(s));
    }
}
