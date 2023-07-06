package leetcode._860LemonadeChange;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description 模拟（贪心）
 * @createTime 2023年07月06日 09:36:00
 */
public class Solution {
    int[] moneyNum = new int[]{0, 0, 0};

    public boolean lemonadeChange(int[] bills) {
        //收钱
        for (int i = 0; i < bills.length; i++) {
            int change = bills[i] - 5;
            //更新钱的张数
            if (bills[i] == 5) {
                moneyNum[0]++;
            } else if (bills[i] == 10) {
                moneyNum[1]++;
            } else {
                moneyNum[2]++;
            }
            //找零
            if (change == 5) {
                //找零5块只有一种情况，
                if (--moneyNum[0] < 0) {
                    return false;
                }
            } else if (change == 15) {
                //找零15有两种情况，三张5块或者一张5块一张1块，优先用大面额（贪心）
                if (moneyNum[1] > 0 && moneyNum[0] > 0) {
                    moneyNum[1]--;
                    moneyNum[0]--;
                } else if (moneyNum[0] > 2) {
                    moneyNum[0] -= 3;
                } else {
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.lemonadeChange(new int[]{5, 5, 10, 10, 20});
    }
}
