package medium._003;

import java.util.HashSet;

public class Solution {
    /**
     * 极度暴力
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) return 0;
        int leng = 1;
        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> list = new HashSet<>();
            list.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (list.contains(s.charAt(j))) {

                    leng = j - i > leng ? j - i : leng;
                    break;
                } else {
                    list.add(s.charAt(j));
                    leng = list.size() > leng ? list.size() : leng;
                }
            }
        }
        return leng;
    }

    //滑动窗口
    public int lengthOfLongestSubstring1(String s) {
        HashSet<Character> set = new HashSet<>();
        //右指针默认在最左侧
        int right = -1;
        int length = 0;
        //左指针不断右移
        for (int i = 0; i < s.length(); i++) {
            //左指针每次左移，子串中取消上一位的记录
            if (i != 0) {
                set.remove(s.charAt(i-1));
            }
            //右指针不停右移且记录不存在的元素到子串，左指针左移后右指针还是从上次的位置移动
            while (right + 1 < s.length() && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                right++;
            }
            length = Math.max(length, right - i + 1);
        }
        return length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("abva"));
        System.out.println(s.lengthOfLongestSubstring1("abva"));
    }
}
