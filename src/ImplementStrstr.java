/**
 * 28. 实现 strStr()
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 * <p>
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class ImplementStrstr {
    public static void main(String[] args) {
        String haystack = "mississippi", needle = "pi";
        System.out.println(strStrNormal(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        if (haystack == null || haystack.length() == 0 && needle != null && needle.length() != 0 || needle == null || haystack.length() < needle.length())
            return -1;
        if (needle.length() == 0) return 0;
        return haystack.indexOf(needle);
    }

    /**
     * 双指针
     * 将 needle（目标字符串） 依次与字符串 haystack 长度为 needle 的子串比较，完全相同则返回子串的数组下标。
     * 一个指针用于遍历，遍历次数为 haystack 多余长度 + 1；一个指针用于依次比较是否与 needle 每一个字符相同
     * 时间复杂度：O(M) = O(M-N) + O(N)
     * 空间复杂度：O(1)
     * <p>
     * 链接：https://leetcode-cn.com/problems/implement-strstr/solution/hua-jie-leetcode28-shi-xian-strstr-by-deppwang-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStrNormal(String haystack, String needle) {
        if (haystack == null || haystack.length() == 0 && needle != null && needle.length() != 0 || needle == null || haystack.length() < needle.length())
            return -1;
        if (needle.length() == 0) return 0;
        int nLen = needle.length();
        int hLen = haystack.length();
        if (haystack.equals(needle)) {
            return 0;
        }
        for (int i = 0; i <= hLen - nLen; i++) {
            int j = 0;
            for (; j < nLen; j++) {
                if (needle.charAt(j) != haystack.charAt(j + i)) {
                    break;
                }
            }
            if (j == nLen) {
                return i;
            }
        }
        return -1;
    }
}
