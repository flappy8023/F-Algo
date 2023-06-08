package leetcode._009回文数;
//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
public class Solution {

    /**将数字反转，然后比较是否与原数字相等
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if(x<0)return false;
        return x==reverseNum(x);
    }
    private int reverseNum(int x){
        int e = 0;
        int num = 0;
        while (x>0){
            e = x%10;
            num =num*10+e;
            x= x/10;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(123));
        System.out.println(new Solution().isPalindrome(121));
        System.out.println(new Solution().isPalindrome(-121));
        System.out.println(new Solution().isPalindrome(1));
    }
}
