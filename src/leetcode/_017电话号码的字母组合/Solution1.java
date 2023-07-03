package leetcode._017电话号码的字母组合;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution1.java
 * @Description TODO
 * @createTime 2023年06月30日 15:31:00
 */
public class Solution1 {
    private List<String> result = new ArrayList<>();
    Map<Character, String> map = new HashMap<>();

    {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if("".equals(digits))return result;
        backTracking(digits, 0, new StringBuilder());
        return result;
    }

    private void backTracking(String digits, int digitIndex, StringBuilder builder) {
        if (digitIndex == digits.length()) {
            result.add(builder.toString());
            return;
        }
        char[] chars = map.get(digits.charAt(digitIndex)).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            builder.append(chars[i]);
            backTracking(digits, digitIndex + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
