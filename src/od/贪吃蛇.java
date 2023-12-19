package od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 贪吃蛇 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] ops = scanner.nextLine().split(" ");
        String[] line2 = scanner.nextLine().split(" ");
        int row = Integer.parseInt(line2[0]);
        int column = Integer.parseInt(line2[1]);
        String[][] area = new String[row][column];
        int[] head = new int[2];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                String point = scanner.next();
                area[i][j] = point;
                //记录蛇头
                if (point.equals("H")) {
                    head = new int[]{i, j};
                }
            }
        }
        List<int[]> snake = new ArrayList<>();
        snake.add(Arrays.copyOf(head, 2));
        String direction = "";
        for (String op : ops) {
            switch (op) {
                case "U":
                case "D":
                case "L":
                case "R":
                    direction = op;
                    break;
                case "G":
                    //向上
                    if (direction.equals("U")) {
                        if (head[0] - 1 >= 0) {
                            int[] newHead = new int[]{head[0] - 1, head[1]};
                            //先判断是否碰到自己 没碰到再看是不是食物
                            if (crushSelf(snake, newHead)) {
                                System.out.println(snake.size());
                                return;
                            } else if (area[newHead[0]][newHead[1]].equals("F")) {
                                snake.add(0, newHead);
                                area[newHead[0]][newHead[1]] = "E";
                            } else {
                                snake.add(0, newHead);
                                snake.remove(snake.size() - 1);
                            }
                            head = newHead;
                        } else {
                            System.out.println(snake.size());
                            return;
                        }
                    } else if (direction.equals("D")) {
                        if (head[0] + 1 < row) {
                            //是否是食物
                            int[] newHead = new int[]{head[0] + 1, head[1]};
                            if (crushSelf(snake, newHead)) {
                                System.out.println(snake.size());
                                return;
                            } else if (area[newHead[0]][newHead[1]].equals("F")) {
                                snake.add(0, newHead);
                                area[newHead[0]][newHead[1]] = "E";

                            } else {
                                snake.add(0, newHead);
                                snake.remove(snake.size() - 1);
                            }
                            head = newHead;
                        } else {
                            System.out.println(snake.size());
                            return;
                        }
                    } else if (direction.equals("L")) {
                        if (head[1] - 1 >= 0) {
                            //是否是食物
                            int[] newHead = new int[]{head[0], head[1] - 1};
                            if (crushSelf(snake, newHead)) {
                                System.out.println(snake.size());
                                return;
                            } else if (area[newHead[0]][newHead[1]].equals("F")) {
                                snake.add(0, newHead);
                                area[newHead[0]][newHead[1]] = "E";

                            } else {
                                snake.add(0, newHead);
                                snake.remove(snake.size() - 1);
                            }
                            head = newHead;
                        } else {
                            System.out.println(snake.size());
                            return;
                        }
                        break;
                    } else if (direction.equals("R")) {
                        if (head[1] + 1 < column) {
                            //是否是食物
                            int[] newHead = new int[]{head[0], head[1] + 1};
                            if (crushSelf(snake, newHead)) {
                                System.out.println(snake.size());
                                return;
                            } else if (area[newHead[0]][newHead[1]].equals("F")) {
                                snake.add(0, newHead);
                                area[newHead[0]][newHead[1]] = "E";

                            } else {
                                snake.add(0, newHead);
                                snake.remove(snake.size() - 1);
                            }
                            head = newHead;
                        } else {
                            System.out.println(snake.size());
                            return;
                        }
                        break;
                    }
            }


        }
        System.out.println(snake.size());
    }

    public static boolean crushSelf(List<int[]> snake, int[] newHead) {
        //移动时忽略现在的尾巴
        for (int i = 0; i < snake.size() - 1; i++) {
            if (snake.get(i)[0] == newHead[0] && snake.get(i)[1] == newHead[1]) {
                return true;
            }
        }
        return false;
    }

}
