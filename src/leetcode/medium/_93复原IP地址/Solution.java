package leetcode.medium._93复原IP地址;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年04月26日 17:56:00
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * <p>
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * <p>
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 20
 * s 仅由数字组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {

    public static void main(String[] args) {
        Solution sl = new Solution();
        List<String> re = sl.restoreIpAddresses("25525511135");
        System.out.printf(re.toString());
    }

    private List<String> result = new ArrayList<>();
    private StringBuilder builder = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {
        backtracking(s, 0, 0);
        return result;
    }

    private void backtracking(String s, int startIndex, int cutNum) {
        //长度达到标准，ip包含三个点
        if (startIndex == s.length() && cutNum == 4) {
            result.add(builder.toString());
            return;
        }
        if (startIndex == s.length() || cutNum == 4) return;
        for (int i = startIndex; i < s.length(); i++) {
            String sub = s.substring(startIndex, i + 1);
            if (isValid(sub)) {
                builder.append(sub);
                if (cutNum < 3) {
                    builder.append(".");
                }
                cutNum++;
                backtracking(s, i + 1, cutNum);
                cutNum--;
                builder.delete(startIndex + cutNum, i + cutNum + 2);
            } else break;
        }
    }

    private boolean isValid(String s) {
        //前导0不合法
        if (s.length() > 1 && s.startsWith("0")) {
            return false;
        }
        //大于255不合法
        if (Integer.parseInt(s) > 255) return false;
        return true;

    }
}