package od;

public class 山脉数量 {
    /**
     * 给定一个数组，数组中的每个元素代表该位置的海拔高度。0表示平地，>=1时表示属于某个山峰，山峰的定义为当某个位置的左右海拔均小于自己的海拔时，该位置为山峰。数组起始位置计算时可只满足一边的条件。
     * 输入描述
     * 一个整数数组
     * 输出描述
     * 输出符合条件的山峰的个数
     * <p>
     * 示例1：
     * 输入：
     * [0,1,2,3,2,4]
     * 输出：
     * 2
     * <p>
     * 示例2：
     * <p>
     * 输入：
     * <p>
     * [3,0,3,4,1]
     * <p>
     * 输出：
     * <p>
     * 2
     * ————————————————
     * 版权声明：本文为CSDN博主「MISAYAONE」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/misayaaaaa/article/details/134352444
     */
    static class Solution {
        public int validMountainCount(int[] arr) {
            int count = 0;
            int length = arr.length;
            if (length == 0) {
                return 0;
            }
            if (length == 1) {
                return arr[0] > 0 ? 1 : 0;
            }
            for (int i = 0; i < length; i++) {
                //起点只判断右侧
                if (i == 0) {
                    if (arr[1] < arr[i]) {
                        count++;
                    }
                } else if (i == length - 1) {
                    if (arr[length - 2] < arr[i]) {
                        count++;
                    }
                } else {
                    if (arr[i - 1] < arr[i] && arr[i + 1] < arr[i]) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int a = solution.validMountainCount(new int[]{0, 1, 2, 3, 2, 4});
        int b = solution.validMountainCount(new int[]{3, 0, 3, 4, 1});
        System.out.println(a+"");
        System.out.println(b+"");

    }
}
