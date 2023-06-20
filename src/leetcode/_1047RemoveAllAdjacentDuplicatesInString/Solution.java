package leetcode._1047RemoveAllAdjacentDuplicatesInString;

import java.util.Arrays;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月14日 10:13:00
 */
public class Solution {
    public String removeDuplicates(String s) {
        char[] chars = new char[s.length()];
        int top = 0;
        for (int i = 0; i < s.length(); i++) {
            if (top > 0 && chars[top - 1] == s.charAt(i)) {
                top--;
            } else {
                chars[top++] = s.charAt(i);
            }
        }
        return new String(Arrays.copyOf(chars, top));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.removeDuplicates("ssAsffs");
        System.out.println(s);
    }
}
