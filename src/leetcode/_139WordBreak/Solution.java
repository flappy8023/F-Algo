package leetcode._139WordBreak;

import java.util.List;

/**
 * @Auther: luweiming
 * @Date: 2023/7/25 09:40
 * @Description: 完全背包
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        //dp[i] 代表长度为j的字符串是否可以用wordDict中单词组成
        //dp[i] =dp[j]&& wordDict.contains(s.subString(j,i))
        //与组合顺序相关，要求排列的方式，所以先遍历背包再遍历物品
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i&&!dp[i]; j++) {
                String sub = s.substring(j, i);
                dp[i] = dp[j] && wordDict.contains(sub);
            }
        }
        return dp[s.length()];
    }
}
