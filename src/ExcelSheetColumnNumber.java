/**
 * 171. Excel表列序号
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 * 输入: "A"
 * 输出: 1
 *
 * 示例 2:
 * 输入: "AB"
 * 输出: 28
 *
 * 示例 3:
 * 输入: "ZY"
 * 输出: 701
 */
public class ExcelSheetColumnNumber {

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 100.00% 的用户内存消耗 : 38.4 MB , 在所有 Java 提交中击败了 5.55% 的用户
     */
    public static int titleToNumberNormal(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }

    /**
     * 执行用时 : 2 ms , 在所有 Java 提交中击败了 39.17% 的用户 内存消耗 : 38.2 MB , 在所有 Java 提交中击败了 5.55% 的用户
     */
    public static int titleToNumber(String s) {
        int ans = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            ans += (Math.pow(26, chars.length - i - 1) * ((int) chars[i] - 64));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumberNormal("ZY"));
    }
}
