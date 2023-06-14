package leetcode.offer._058左旋转字符串;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月13日 16:55:00
 */
public class Solution {
    public String reverseLeftWords(String s, int n) {
        char[] origins = s.toCharArray();
        char[] result = new char[s.length()];
        for (int i = 0; i < s.length() - n; i++) {
            result[i] = origins[i + n];
        }
        for (int i = s.length() - n; i < s.length(); i++) {
            result[i] = origins[i - (s.length() - n)];
        }
        return new String(result);
    }

    public String reverseLeftWords1(String s, int n) {
        char[] chars = s.toCharArray();
        //1.先反转0-n
        reverse(chars,0,n-1);
        //2.再反转n-s.length
        reverse(chars,n,s.length()-1);
        //3.最后整体反转
        reverse(chars,0,s.length()-1);
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            chars[start] = (char) (chars[start] ^ chars[end]);
            chars[end] = (char) (chars[start] ^ chars[end]);
            chars[start] = (char) (chars[start] ^ chars[end]);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseLeftWords1("abcdefg", 2));
    }
}
