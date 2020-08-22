package easy._007;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class Solution {
    public int reverse(int x) {
        long ret = 0;
        while (x != 0) {
            int e = x % 10;
            x = x / 10;
            ret = ret * 10 + e;
        }
        return (int) ret == ret ? (int) ret : 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(-12435));
    }
}
