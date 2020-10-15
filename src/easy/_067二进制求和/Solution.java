package easy._067二进制求和;

/*给你两个二进制字符串，返回它们的和（用二进制表示）。

        输入为 非空 字符串且只包含数字 1 和 0。

         

        示例 1:

        输入: a = "11", b = "1"
        输出: "100"
        示例 2:

        输入: a = "1010", b = "1011"
        输出: "10101"
         

        提示：

        每个字符串仅由字符 '0' 或 '1' 组成。
        1 <= a.length, b.length <= 10^4
        字符串如果不是 "0" ，就都不含前导零。*/
public class Solution {
    public String addBinary(String a, String b) {
        char[] charsLong, charsShort;
        if (a.length() > b.length()) {
            charsLong = a.toCharArray();
            charsShort = b.toCharArray();
        } else {
            charsLong = b.toCharArray();
            charsShort = a.toCharArray();
        }
        int d = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = charsLong.length - 1; i >= 0; i--) {
            int j = i - (charsLong.length - charsShort.length);
            int temp = charsLong[i] - '0';
            if (j >= 0) {
                builder.append((char) (((charsLong[i] - '0') + (charsShort[j] - '0') + d) % 2 + '0'));
                d = (temp + (charsShort[j] - '0') + d) / 2;
            } else {
                builder.append((char) (((charsLong[i] - '0') + d) % 2 + '0'));
                d = (temp + d) / 2;
            }
        }
        if (d > 0) {
            builder.append("1");
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("11", "1"));
    }
}
