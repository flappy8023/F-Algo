package leetcode._038外观数列;

/*

给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。

        注意：整数序列中的每一项将表示为一个字符串。

        「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：

        1.     1
        2.     11
        3.     21
        4.     1211
        5.     111221
        第一项是数字 1

        描述前一项，这个数是 1 即 “一个 1 ”，记作 11

        描述前一项，这个数是 11 即 “两个 1 ” ，记作 21

        描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211

        描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221



        示例 1:

        输入: 1
        输出: "1"
        解释：这是一个基本样例。
        示例 2:

        输入: 4
        输出: "1211"
        解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。*/
public class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        //master commit
        String item = countAndSay(n - 1);
        int first = 0;
        int count = 1;
        StringBuilder result = new StringBuilder();
        while (first < item.length()) {
            char a = item.charAt(first);
            int second = first + 1;
            count = 1;
            while (second < item.length() && item.charAt(second) == a) {
                second++;
                count++;
                first++;
            }
            first++;
            result.append(count);
            result.append(a);
        }
        return result.toString();
    }

    public String countAndSay1(int n) {
        if (n == 1) {
            return "1";
        }
        String item = countAndSay1(n - 1);
        int first = 0;
        int count = 0;
        char c = item.charAt(0);
        StringBuilder result = new StringBuilder();
        while (first < item.length()) {
            char a = item.charAt(first);
            if (c == a) {
                count++;
                first++;
            } else {
                result.append(count).append(c);
                c = item.charAt(first);
                first++;
                count = 1;

            }
        }
        result.append(count);
        result.append(c);
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String a = solution.countAndSay(6);
    }
}
