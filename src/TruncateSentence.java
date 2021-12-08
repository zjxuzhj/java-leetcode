/**
 * 1816. 截断句子
 * 句子 是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。每个单词仅由大小写英文字母组成（不含标点符号）。
 * <p>
 * 例如，"Hello World"、"HELLO" 和 "hello world hello world" 都是句子。
 * 给你一个句子 s 和一个整数 k ，请你将 s 截断，使截断后的句子仅含 前 k 个单词。返回 截断 s 后得到的句子。
 * <p>
 * 示例 3：
 * 输入：s = "chopper is not a tanuki", k = 5
 * 输出："chopper is not a tanuki"
 */
public class TruncateSentence {

    public static String truncateSentence(String s, int k) {
        String[] s1 = s.split(" ");
        if (s1.length <= 1) {
            return s;
        } else {
            if (k > 1) {
                StringBuilder a = new StringBuilder();
                for (int i = 0; i < k; i++) {
                    if (i == k - 1) {
                        a.append(s1[i]);
                    } else {
                        a.append(s1[i]).append(" ");
                    }
                }
                return a.toString();
            } else {
                return s1[k - 1];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(truncateSentence("chopper is not a tanuki", 5));
    }
}
