package od;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class 机器人走迷宫 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int[][] area = new int[x][y];

            List<int[]> path = new ArrayList<>();
            int n = scanner.nextInt();
            //-1标识墙   0代表没走过 1代表能走  2代表能到终点
            area[0][0] = 2;

            for (int i = 0; i < n; i++) {
                area[scanner.nextInt()][scanner.nextInt()] = -1;
            }
            //把能走的路径全部走一遍，记录能到达终点的路径
            dfs(area, 0, 0, path);
            //排除掉没有走到的位置、墙、能到达终点的位置，剩下的就是陷阱位置
            int unReachNum = 0;
            int goFinalNum = 0;
            for (int i = 0; i < area.length; i++) {
                for (int j = 0; j < area[0].length; j++) {
                    if (area[i][j] == 0) {
                        unReachNum++;
                    } else if (area[i][j] == 2) {

                        goFinalNum++;

                    }
                }
            }
            int trapNum = x * y - n - unReachNum - goFinalNum;
            System.out.println(trapNum + " " + unReachNum);

        }
    }

    public static void dfs(int[][] area, int x, int y, List<int[]> path) {
        if (x == area.length-1 && y == area[0].length-1) {
            for (int[] point : path) {
                area[point[0]][point[1]] = 2;
            }
            return;
        }
        for (int i = 0; i < 2; i++) {
            //向东
            if (i == 0) {
                //没有越界 且没有撞墙
                if (x + 1 <= area.length - 1 && area[x + 1][y] != -1) {
                    if (area[x + 1][y] == 0) {
                        area[x + 1][y] = 1;
                    }
                    path.add(new int[]{x + 1, y});
                    dfs(area, x + 1, y, path);
                    path.remove(path.size() - 1);
                }
            } else {//向北

                //没有越界 且没有撞墙
                if (y + 1 <= area[0].length - 1 && area[x][y + 1] != -1) {
                    if (area[x][y + 1] == 0) {
                        area[x][y + 1] = 1;
                    }
                    path.add(new int[]{x, y + 1});
                    dfs(area, x, y + 1, path);
                    path.remove(path.size() - 1);
                }
            }
        }
    }


}
