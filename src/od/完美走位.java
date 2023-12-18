package od;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 完美走位 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] chars = input.toCharArray();
        //字母与出现次数对应关系
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }
        //是否平衡的标识，即所有字母出现次数相同
        boolean flag = true;
        //平衡时每个字母需要出现的次数
        int avg = input.length() / 4;
        //记录所有多余的字符个数
        int total = 0;
        for (Character c : map.keySet()) {
            //此后map的含义变成每个字母多余出现的次数
            if (map.get(c) > avg) {
                map.put(c, map.get(c) - avg);
                flag = false;
                total += map.get(c);
            } else {
                map.put(c, 0);
            }
        }
        if (flag) {
            System.out.println("0");
            return;
        }
        //滑动窗口
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        while (right < input.length()) {
            //窗口右侧进来的字符是多余的
            if (map.get(chars[right]) > 0) {
                total--;
            }
            //
            map.put(chars[right], map.get(chars[right]) - 1);
            //达到平衡
            while (total == 0) {
                minLength = Math.min(minLength, right - left + 1);
                //窗口左侧如果是多余字符
                if (map.get(chars[left]) >= 0) {
                    total++;
                }
                map.put(chars[left], map.get(chars[left]) + 1);
                left++;
            }
            right++;
        }
        System.out.println(minLength);
    }
}
