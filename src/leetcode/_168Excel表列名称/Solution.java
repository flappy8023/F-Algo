package leetcode._168Excel表列名称;

import java.util.HashMap;
import java.util.Map;

/*给定一个正整数，返回它在 Excel 表中相对应的列名称。

        例如，

        1 -> A
        2 -> B
        3 -> C
        ...
        26 -> Z
        27 -> AA
        28 -> AB
        ...
        示例 1:

        输入: 1
        输出: "A"
        示例 2:

        输入: 28
        输出: "AB"
        示例 3:

        输入: 701
        输出: "ZY"*/
public class Solution {
    public String convertToTitle(int n) {
        Map<Integer, String> map = new HashMap<>();
        String[] arr = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        for (int i = 0; i < arr.length; i++) {
            map.put(i + 1, arr[i]);
        }
        map.put(0, "Z");
        StringBuilder builder = new StringBuilder();
        while (n > 26) {
            int mod = n % 26;
            builder.append(map.get(mod));
            if (mod == 0) {
                n = n / 26 - 1;
            } else {
                n = n / 26;
            }
        }
        builder.append(map.get(n % 26));
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convertToTitlte1(52));
    }
    public String convertToTitlte1(int n){
        StringBuilder builder = new StringBuilder();
        while (n>0){
            n-=1;
            int mod = n%26;
            builder.insert(0,(char) ('A'+mod));
            n/=26;
        }
        return builder.toString();
    }
}
