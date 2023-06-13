package leetcode._541ReverseStringII;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月13日 10:27:00
 */
public class Solution {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            //
            if (i + k < chars.length) {
                reverse(chars,i,i+k-1);
            }else {
                reverse(chars,i,chars.length-1);
            }
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int left, int right) {
        while (left<right){
            chars[left] = (char) (chars[left]^chars[right]);
            chars[right] = (char) (chars[left]^chars[right]);
            chars[left] = (char) (chars[left]^chars[right]);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseStr("abcdefg", 2));
    }

}
