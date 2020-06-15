/**
 * 168. Excel表列名称
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * 示例 1:
 * 输入: 1
 * 输出: "A"
 *
 * 示例 2:
 * 输入: 28
 * 输出: "AB"
 *
 * 示例 3:
 * 输入: 701
 * 输出: "ZY"
 */
public class ExcelSheetColumnTitle {
    static String ans = "";

    /**
     * 执行用时 :10 ms , 在所有 Java 提交中击败了7.19%的用户 内存消耗 : 37.5 MB , 在所有 Java 提交中击败了 14.29%的用户
     */
    public static String convertToTitle(int n) {
        if (n <= 26) {
            ans = (char) (n + 64) + ans;
        } else {
            if (n % 26 == 0) {
                ans = "Z" + ans;
                convertToTitle(n / 26 - 1);
            } else {
                ans = (char) (n % 26 + 64) + ans;
                convertToTitle(n / 26);
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(1048));
    }
}
