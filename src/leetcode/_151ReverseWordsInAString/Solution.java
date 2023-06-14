package leetcode._151ReverseWordsInAString;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月13日 14:51:00
 */
public class Solution {
    public String reverseWords(String s) {
        char[] result = new char[s.length()];
        int right = s.length() - 1;
        int left = right;
        int index = 0;
        while (left >= 0 && left <= right) {
            if (s.charAt(right) == ' ') {
                right--;
                left--;
                if (index > 0 && result[index - 1] != ' ') {
                    result[index++] = ' ';
                }
            } else {
                //找到单词开头位置
                while (left >= 0 && s.charAt(left) != ' ') {
                    left--;
                }
                int start = left + 1;
                //填充一个单词
                while (start <= right) {
                    result[index++] = s.charAt(start++);
                }
                right = left;
            }
        }
        int count = 0;
        //处理最后的空格
        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i] != 0) {
                if (result[i] == ' ') {
                    count = i;
                    break;
                } else {
                    count = i + 1;
                    break;
                }
            }
        }
        return new String(result, 0, count);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("a good  example"));
    }
}
