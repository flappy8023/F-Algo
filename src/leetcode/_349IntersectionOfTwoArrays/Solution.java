package leetcode._349IntersectionOfTwoArrays;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月12日 10:30:00
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] nums = new int[1001];
        for (int i = 0; i < nums1.length; i++) {
            nums[nums1[i]] = 1;
        }
        int count = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (nums[nums2[i]] ==1) {
                count++;
                nums[nums2[i]] = 2;
            }
        }
        int[] result = new int[count];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 2) {
                result[--count] = i;
            }
        }
        return result;
    }

}
