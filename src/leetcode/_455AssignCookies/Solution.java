package leetcode._455AssignCookies;

import java.util.Arrays;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description 分发饼干-贪心
 * @createTime 2023年07月04日 16:15:00
 */
public class Solution {
    /**
     * @param g 孩子的需求
     * @param s 饼干的大小
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int childIndex = g.length - 1;
        int cookieIndex = s.length - 1;
        //大饼干先满足大胃口
        while (childIndex >= 0 && cookieIndex >= 0) {
            //当前最大的饼干可以满足胃口最大的孩子，那么找下一个胃口最大的孩子和下一个最大的饼干进行比较
            if (s[cookieIndex] >= g[childIndex]) {
                count++;
                cookieIndex--;
                childIndex--;
            } else {
                //当前最大的饼干满足不了当前最大胃口的孩子，那么尝试用当前最大的饼干和下一个胃口最大的孩子比较
                childIndex--;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1});
        System.out.println(result);
    }
}
