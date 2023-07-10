package leetcode._738MonotoneIncreasingDigits;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年07月07日 15:52:00
 */
public class Solution {
    public int monotoneIncreasingDigits(int n) {//n=1234
        //n的范围0---10^9
        int[] digits = new int[10];//digits = [4,3,2,1,0,0,0,0,0,0]
        //记录位数
        int count = 0;
        while (n != 0) {
            digits[count++] = n % 10;
            n /= 10;
        }
        for (int i = count - 1; i > 0; i--) {
            //当前位比前一位大什么都不做，比前一位小，当前位减一，后面所有数字都变成9
            if (digits[i] > digits[i - 1]) {
                digits[i]--;
                for (int j = 0; j <= i - 1; j++) {
                    digits[j] = 9;
                }
                //从头开始比较
                i = count;
            }
        }
        int num = 0;
        for (int i = count - 1; i >= 0; i--) {
            num = num * 10 + digits[i];
        }

        return num;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.monotoneIncreasingDigits(332);
    }
}
