package leetcode._344ReverseString;

import java.util.Arrays;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月13日 10:11:00
 */
public class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        char temp;
        while (left < right) {
            s[left] = (char) (s[left] ^ s[right]);
            s[right] = (char) (s[left] ^ s[right]);
            s[left] = (char) (s[left] ^ s[right]);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[] chars = "hello".toCharArray();
        solution.reverseString(chars);
        System.out.println(Arrays.toString(chars));
    }
}
