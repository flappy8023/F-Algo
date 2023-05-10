package leetcode.medium._017电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number
 */
class Solution {

    private List<String> result = new ArrayList<>();
    //可以用数组替换，下标0，1留空
//    private HashMap<Character, String> map = new HashMap<>();
//
//    {
//        map.put('2', "abc");
//        map.put('3', "def");
//        map.put('4', "ghi");
//        map.put('5', "jkl");
//        map.put('6', "mno");
//        map.put('7', "pqrs");
//        map.put('8', "tuv");
//        map.put('9', "wxyz");
//    }
    private String[] array = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return result;
        }
        backTracking(0, digits, new StringBuilder());
        return result;
    }

    private void backTracking(int index, String digits, StringBuilder builder) {
        if (builder.length() == digits.length()) {
            result.add(builder.toString());
            return;
        }
        String value = array[Character.getNumericValue(digits.charAt(index))];
        for (int i = 0; i < value.length(); i++) {
            builder.append(value.charAt(i));
            backTracking(index + 1, digits, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }


}