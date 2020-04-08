/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }

        // 第一个字符串当模板串
        String firstString = strs[0];

        // 模板串的字符，逐个测试
        for(int i=0; i<firstString.length(); i++){

            char tmpStr = firstString.charAt(i);
            for(int j=1; j<strs.length; j++){
                if(i>(strs[j].length()-1) || tmpStr!=strs[j].charAt(i) ){
                    return new String(firstString.substring(0,i));
                }
            }
        }

        return firstString;
    }

    public static void main(String[] args) {
        String[] strings = {"a", "a"};
        String s = longestCommonPrefix(strings);
        System.out.println(s);
    }
}
