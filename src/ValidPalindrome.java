/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 */
public class ValidPalindrome {
    /**
     * 使用从中间取值需要增加一倍的代码，所以用头尾双指针进行判断
     *
     * 分享个字母大小写转换的方法：
     *
     * 统一转成大写：ch & 0b11011111 简写：ch & 0xDF
     * 统一转成小写：ch | 0b00100000 简写：ch | 0x20
     * 比较的时候注意加上小括号哦，因为位运算优先级比较低。
     * 使用示例：
     * if((s.charAt(i ++) & 0xDF) != (s.charAt(j --) & 0xDF)) return false;
     *
     * 执行用时 : 30 ms , 在所有 Java 提交中击败了 14.41% 的用户 内存消耗 : 40.7 MB , 在所有 Java 提交中击败了 7.14% 的用户
     */
    public static boolean isPalindrome(String s) {
        //正则过滤除数字字母外所有字符
        s = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
        if ("".equals(s)) {
            return true;
        }
        int left = 0, right = s.length() - 1;
//        int mid = s.length() / 2;
        while (right > left) {
            if ((s.charAt(left) & 0xDF) != (s.charAt(right) & 0xDF)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "race a car";
        System.out.println(isPalindrome(s));
    }
}

