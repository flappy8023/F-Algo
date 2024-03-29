package leetcode._069x的平方根;

//计算并返回 x 的平方根，其中 x 是非负整数。
//
//        由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
//
//        示例 1:
//
//        输入: 4
//        输出: 2
//        示例 2:
//
//        输入: 8
//        输出: 2
//        说明: 8 的平方根是 2.82842...,
//             由于返回类型是整数，小数部分将被舍去
public class Solution {
    //二分法
    public int mySqrt(int x) {
        int low = 0;
        if (x == 1) return 1;
        int high = x;
        while (low +1< high) {
            int mid = (low + high) / 2;
            if ((long) mid * mid > x) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(5));
    }
}
