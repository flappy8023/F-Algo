package leetcode._136只出现一次的数字;
/*给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

        说明：

        你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

        示例 1:

        输入: [2,2,1]
        输出: 1
        示例 2:

        输入: [4,1,2,1,2]
        输出: 4

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/single-number
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int a:nums){
            if(set.contains(a)){
                set.remove(a);
            }else {
                set.add(a);
            }
        }
        return (int) set.toArray()[0];
    }
//    交换律：a ^ b ^ c <=> a ^ c ^ b
//
//    任何数于0异或为任何数 0 ^ n => n
//
//    相同的数异或为0: n ^ n => 0
    public int singleNumber1(int[] nums){
        int a = 0;
        for (int n:nums){
            a^=n;
        }
        return a;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();

        System.out.println(solution.singleNumber1(new int[]{1,1,2,2,3,4,3}));
    }
}
