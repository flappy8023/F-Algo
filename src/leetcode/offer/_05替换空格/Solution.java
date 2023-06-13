package leetcode.offer._05替换空格;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月13日 11:10:00
 */
public class Solution {
    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public String replaceSpace1(String s) {
        int count = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count += 2;
            }
        }
        char[] chars = new char[count];
        int left = s.length() - 1;
        int right = count - 1;
        while (left >= 0) {
            if (s.charAt(left) == ' ') {
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right--] = '%';
            } else {
                chars[right--] = s.charAt(left);
            }
            left--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.replaceSpace1("He wo lj"));
    }
}
