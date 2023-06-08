package leetcode._066加一;
/*给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

        最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

        你可以假设除了整数 0 之外，这个整数不会以零开头。

        示例 1:

        输入: [1,2,3]
        输出: [1,2,4]
        解释: 输入数组表示数字 123。
        示例 2:

        输入: [4,3,2,1]
        输出: [4,3,2,2]
        解释: 输入数组表示数字 4321。*/

public class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                digits[i]++;
            }
            if (10 == digits[i]) {
                digits[i]=0;
                if (i > 0) {
                    digits[i - 1] += 1;
                } else {
                    int[] arr = new int[digits.length + 1];
                    arr[0] = 1;
                    System.arraycopy(digits, 0, arr, 1, digits.length);
                    return arr;
                }
            }


        }
        return digits;
    }

    public int[] plusOne1(int[] digits){
        for(int i=digits.length-1;i>=0;i--){
            digits[i]++;
            digits[i]=digits[i]%10;
            //当前位没有进位直接返回
            if(digits[i]!=0){
                return digits;
            }
        }
        int[] arr=new int[digits.length+1];
        arr[0]=1;
        return arr;
    }

    public static void main(String[] args) {
        new Solution().plusOne1(new int[]{1, 2, 3});
    }
}
