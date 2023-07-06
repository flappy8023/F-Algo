package leetcode._406QueueReconstructionByHeight;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description 贪心
 * @createTime 2023年07月06日 22:12:00
 */
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        //两个维度：身高和不比当前低的人数 类似135：分发糖果，需要先固定一个维度。
        //人数无法固定，只能先根据身高
        //首先根据身高h降序排列，身高相同的情况下，前面人数k小的排前面（k升序）
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //身高相同，按照前方人数升序
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                //身高降序
                return o2[0]-o1[0];
            }
        });
        LinkedList<int[]> list = new LinkedList<>();
        //按照身高排序后，再根据前面人数k进行插入到相对应的位置
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1],people[i]);
        }
        return list.toArray(new int[people.length][]);

    }
}
