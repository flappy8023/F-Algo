package adv;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Monkey_and_Banana.java
 * @Description TODO
 * @createTime 2023年05月12日 17:36:00
 */
public class Monkey_and_Banana {
    static int res = Integer.MIN_VALUE;

    static class Block {
        int x, y, z;

        public Block(int a, int b, int c) {
            x = a;
            y = b;
            z = c;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index = 1;
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            if (num == 0) return;
            Block[] blocks = new Block[num * 3];

            for (int i = 0; i < num; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int z = scanner.nextInt();
                blocks[3 * i] = new Block(x, y, z);
                blocks[3 * i + 1] = new Block(x, z, y);
                blocks[3 * i + 2] = new Block(y, z, x);
            }
            Arrays.sort(blocks, new Comparator<Block>() {
                @Override
                public int compare(Block o1, Block o2) {
                    if (o1.x == o2.x) return o1.y - o2.y;
                    return o1.x - o2.x;
                }
            });
            int[] dp = new int[num * 3];
            for (int i = 0; i < num * 3; i++) {
                dp[i] = blocks[i].z;
                for (int j = 0; j < i; j++) {
                    if (blocks[i].x < blocks[j].x && blocks[i].y < blocks[j].y) {
                        dp[i] = Math.max(dp[i], blocks[i].z + dp[j]);
                    }
                }
            }
            res = Integer.MIN_VALUE;
            for (int i = 0; i < dp.length; i++) {
                res = Math.max(res, dp[i]);
            }
            System.out.println("Case " + (index++) + ":maximum height = " + res);
        }
    }
}
