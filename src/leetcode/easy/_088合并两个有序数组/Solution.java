package leetcode.easy._088合并两个有序数组;
/*给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

         

        说明：

        初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
        你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
         

        示例：

        输入：
        nums1 = [1,2,3,0,0,0], m = 3
        nums2 = [2,5,6],       n = 3

        输出：[1,2,2,3,5,6]
         

        提示：

        -10^9 <= nums1[i], nums2[i] <= 10^9
        nums1.length == m + n
        nums2.length == n*/

import java.util.Arrays;

public class Solution {
    //先合并在排序
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m, p2 = 0;
        while (p2 < n) {
            nums1[p1] = nums2[p2];
            p1++;
            p2++;
        }
        Arrays.sort(nums1);
    }

    //双指针、从前往后
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int index = 0;
        int[] nums = Arrays.copyOf(nums1, nums1.length);
        while (index < m + n) {
            if ((p2 >= n || nums[p1] < nums2[p2])&&p1<m) {
                nums1[index] = nums[p1];
                p1++;
            } else if ((p1 >= m || nums[p1] >= nums2[p2])&&p2<n) {
                nums1[index] = nums2[p2];
                p2++;
            }
            index++;
        }
    }

    //双指针、从后往前,占用nums1后面空闲空间，不需要开辟额外空间
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1=m-1;
        int p2  =n-1;
        int p=m+n-1;
        while (p1>=0&&p2>=0){
            if(nums1[p1]<nums2[p2]){
                nums1[p--] = nums2[p2--];
            }else {
                nums1[p--]  = nums1[p1--];
            }
        }
        System.arraycopy(nums2,0,nums1,0,p2+1);
    }
        public static void main(String[] args) {
        new Solution().merge1(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);
    }
}
