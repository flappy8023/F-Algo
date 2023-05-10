package adv;

import java.util.Scanner;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName The_Followship_of_the_Ring.java
 * @Description TODO
 * @createTime 2023年05月05日 11:03:00
 */

/**
 * https://blog.csdn.net/qq_42837890/article/details/125090466
 */
public class The_Followship_of_the_Ring {
    /**
     * 兽人群组列表
     */
    static int[] orcs;
    /**
     * 每组兽人需要的过路费
     */
    static int[] tolls;
    /**
     * 最小花费
     */
    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = Integer.parseInt(scanner.nextLine());
        System.out.println();
        for (int i = 0; i < cases; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            orcs = new int[num];
            tolls = new int[num];
            for (int j = 0; j < num; j++) {
                String[] s = scanner.nextLine().split(" ");
                orcs[j] = Integer.parseInt(s[0]);
                tolls[j] = Integer.parseInt(s[1]);
            }
            min = Integer.MAX_VALUE;
            dfs(0, 0, 0, 0, 0);
            System.out.println("#" + (i + 1) + " " + min);
        }
    }

    /**
     * @param group 第几组兽人
     * @param cost  总花费
     * @param used0 还没战斗过的雇佣兵数
     * @param used1 参与过一次战斗的雇佣兵数
     * @param used2 参与过两次战斗的雇佣兵数
     */
    private static void dfs(int group, int cost, int used0, int used1, int used2) {
        //该路径花费已超过最小花费，没有必要继续
        if (cost > min) {
            return;
        }
        //通过了全部兽人群
        if (group == orcs.length) {
            min = cost;
            return;
        }

        int orcNum = orcs[group];
        int toll = tolls[group];
        //1.花买路钱
        dfs(group + 1, cost + toll, used0, used1, used2);
        //2.花双倍钱进行雇佣
        dfs(group + 1, cost + toll * 2, used0 + orcNum, used1, used2);
        //3.进行战斗
        if (used0 + used1 + used2 >= orcNum) {
           /* //还有一次可战斗机会的佣兵数量大于兽人数量，只用剩一次机会的
            if (used2 >= orcNum) {
                dfs(group + 1, cost, used0, used1, used2 - orcNum);
            }
            //先使用只剩一次的，用完之后使用还剩两次机会的
            else if (used1 + used2 >= orcNum) {
                dfs(group + 1, cost, used0, used1 + used2 - orcNum, 0);
            }
            //剩一次的和剩两次的都不够用
            else {
                dfs(group + 1, cost, used0 + used1 + used2 - orcNum, 0, 0);
            }*/
            //参与一次战斗，所有雇佣兵的战斗次数+1？？？
            //还有一次可战斗机会的佣兵数量大于兽人数量，只用剩一次机会的
            if (used2 >= orcNum) {
                dfs(group + 1, cost, 0, used0, used1);
            }
            //先使用只剩一次的，用完之后使用还剩两次机会的
            else if (used1 + used2 >= orcNum) {
                dfs(group + 1, cost, 0, used0, used1 + used2 - orcNum);
            }
            //剩一次的和剩两次的都不够用
            else {
                dfs(group + 1, cost, 0, used0 + used1 + used2 - orcNum, 0);
            }
        }

    }
}
