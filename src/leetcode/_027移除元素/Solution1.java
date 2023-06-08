package leetcode._027移除元素;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution1.java
 * @Description 暴力解法，0(n^2)
 * @createTime 2023年06月08日 10:22:00
 */
public class Solution1 {
    public int removeElement(int[] nums, int val) {
        int k = nums.length;
        for (int i = 0; i < k; i++) {
            if (nums[i] == val) {
                removeIndex(nums, i, k);
                i--;
                k--;
            }
        }
        return k;
    }

    private void removeIndex(int[] nums, int index, int k) {
        for (int i = index; i < k - 1; i++) {
            nums[i] = nums[i + 1];
        }
    }
}
