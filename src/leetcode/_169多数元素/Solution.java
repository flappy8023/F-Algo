package leetcode._169多数元素;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

        你可以假设数组是非空的，并且给定的数组总是存在多数元素。

         

        示例 1:

        输入: [3,2,3]
        输出: 3
        示例 2:

        输入: [2,2,1,1,1,2,2]
        输出: 2

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/majority-element
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int a:nums){
            if(map.containsKey(a)){
                map.put(a,map.get(a)+1);
            }else {
                map.put(a,1);
            }
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>nums.length/2){
                return entry.getKey();
            }
        }
        return 0;
    }
    //排序然后取中间一个
    public int majorityElement1(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    //投票法，
    public int majortyElement2(int[] nums){
        int marjor=0;//候选众数
        int count = 0;//众数出现次数
        for (int x:nums){
            if(count==0){
                marjor = x;
            }
            if(marjor==x){
                count++;
            }else {
                count--;
            }
        }
        return marjor;
    }
}
