package leetcode._001两数之和;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
 /*   给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

    你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。*/

    /* 给定 nums = [2, 7, 11, 15], target = 9

     因为 nums[0] + nums[1] = 2 + 7 = 9
     所以返回 [0, 1]

     来源：力扣（LeetCode）
     链接：https://leetcode-cn.com/problems/two-sum
     著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
        System.out.println(Arrays.toString(twoSum1(nums, target)));
        System.out.println(Arrays.toString(twoSum2(nums, target)));


    }

    //两重循环，比较任意两个元素的和是否等于target
    // 时间复杂度 O(n^2)  空间复杂度O(1)
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException();
    }

    //两次循环,第一次循环建立每个元素与其下标的映射关系保存在哈希表中，二次循环查找每个元素对应的目标元素（target-nums[i]）
    // 是否在表中，注：对应目标元素不能是其本身
    //时间复杂度 O(n)  空间复杂度 O(n)
    public static int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i]) && i != hashMap.get(target - nums[i])) {
                return new int[]{i, hashMap.get(target - nums[i])};
            }
        }
        throw new IllegalArgumentException();
    }

    //一遍哈希表，迭代时将目标元素(target-nums[i])作为key，当前下标作为value保存到哈希表，先检查当前元素在不在哈希表中，不存在时进行添加。
    //时间复杂度 O(n) 空间复杂度O(n)
    public static int[] twoSum2(int[] nums,int target){
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(hashMap.containsKey(nums[i])){
                return new int[]{hashMap.get(nums[i]),i};
            }
            hashMap.put(target-nums[i],i);
        }
        throw new IllegalArgumentException();
    }
}
