package leetcode._167两数之和II_输入有序数组;
/*给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

        函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

        说明:

        返回的下标值（index1 和 index2）不是从零开始的。
        你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
        示例:

        输入: numbers = [2, 7, 11, 15], target = 9
        输出: [1,2]
        解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。*/

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = 1;
        while (left < numbers.length - 1) {
            while (right < numbers.length) {
                if (target == numbers[left] + numbers[right]) {
                    return new int[]{left + 1, right + 1};
                }
                right++;
            }
            left++;
            right = left + 1;
        }
        return new int[2];
    }
    public int[] twoSum1(int[] numbers,int target){
     int left=0;
     int right = numbers.length-1;
     while (left<right){
         if(numbers[left]+numbers[right]>target){
             right--;
         } else if (numbers[left] + numbers[right]<target) {
            left++;
         }else {
             return new int[]{left+1,right+1};
         }
     }
     return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        new Solution().twoSum1(new int[]{0,0,3,4},0);
    }
}
