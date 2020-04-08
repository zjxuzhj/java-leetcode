import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 */

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValidStack("{[]}"));
    }

    /**
     * 使用字符串替换法，把所有符合条件的框给换掉，因为所有字符只存在括号
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if (s.equals(""))
            return true;
        while (true) {
            int length = s.length();
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
            if (length == s.length())
                break;
        }
        return s.length() == 0;
    }

    /**
     * 使用栈
     * <p>
     * 使用栈复杂度分析
     * <p>
     * 时间复杂度：O(n)，因为我们一次只遍历给定的字符串中的一个字符并在栈上进行 O(1)O(1) 的推入和弹出操作。
     * 空间复杂度：O(n)，当我们将所有的开括号都推到栈上时以及在最糟糕的情况下，我们最终要把所有括号推到栈上。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/valid-parentheses/solution/you-xiao-de-gua-hao-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public static boolean isValidStack(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (stack.isEmpty()) {
                stack.push(aChar);
            } else if (stack.peek() == '(' && aChar == ')' || stack.peek() == '[' && aChar == ']' || stack.peek() == '{' && aChar == '}') {
                stack.pop();
            } else {
                stack.push(aChar);
            }
        }
        return stack.isEmpty();
    }
}

