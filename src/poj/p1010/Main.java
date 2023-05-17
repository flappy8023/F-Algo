package poj.p1010;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Main.java
 * @Description TODO
 * @createTime 2023年05月17日 14:21:00
 */
public class Main {
    static Sale bestSale;

    static class Sale {
        int[] saled;
        int value;
        int count;
        boolean tie = false;

        public Sale(int[] s, int v, int vc) {
            saled = s;
            value = v;
            count = vc;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] values = new int[10000];
            int v0 = scanner.nextInt();
            //邮票类型数量
            int vCount = 0;
            while (v0 != 0) {
                values[vCount++] = v0;
                v0 = scanner.nextInt();
            }
            Arrays.sort(values, 0, vCount);
            //换行
            scanner.nextLine();
            int[] customers = new int[10000];
            int c0 = scanner.nextInt();
            //顾客数量
            int cCount = 0;
            while (c0 != 0) {
                customers[cCount++] = c0;
                c0 = scanner.nextInt();
            }
            //对每个顾客的需求单独处理
            for (int i = 0; i < cCount; i++) {
                bestSale = null;
                dfs(customers[i], values, vCount, new Sale(new int[vCount], 0, 0), 0, 0);
                if (null == bestSale) {
                    System.out.println(customers[i] + " ---- none");
                } else {
                    if (bestSale.tie) {
                        System.out.println(customers[i] + " (" + getTypeCount(bestSale) + ") : tie");
                    } else {
                        System.out.print(customers[i] + " (" + getTypeCount(bestSale) + ") :");
                        for (int i1 = 0; i1 < bestSale.saled.length; i1++) {
                            for (int k = 0; k < bestSale.saled[i1]; k++) {
                                System.out.print(" " + values[i1]);
                            }
                        }
                        System.out.println();
                    }
                }
            }
            scanner.nextLine();
        }
    }

    private static void dfs(int request, int[] values, int vCount, Sale sale, int stampCount, int index) {
        if (stampCount > 4) {
            return;
        }
        if (stampCount == 4 && sale.value != request) {
            return;
        }
        if (sale.value > request) {
            return;
        }
        if (sale.value == request) {

            //记录
            if (bestSale != null) {
                int bestC = getTypeCount(bestSale);
                int nowC = getTypeCount(sale);
                //当前邮票种类大于之前最优解，更新最优解
                if (nowC > bestC) {
                    bestSale = new Sale(Arrays.copyOf(sale.saled, sale.saled.length), sale.value, sale.count);
                }
                //种类相同的情况下，总数少的为最优解
                else if (nowC == bestC) {
                    if (sale.count < bestSale.count) {
                        bestSale = new Sale(Arrays.copyOf(sale.saled, sale.saled.length), sale.value, sale.count);
                    } else if (sale.count == bestSale.count) {
                        bestSale.tie = true;
                    }
                }
            } else {
                bestSale = new Sale(Arrays.copyOf(sale.saled, sale.saled.length), sale.value, sale.count);
            }
            return;
        }
        for (int i = index; i < vCount; i++) {
            //对应类型邮票数量增加
            sale.saled[i]++;
            //面值增加
            sale.value += values[i];
            sale.count++;
            dfs(request, values, vCount, sale, stampCount + 1, i);
            sale.value -= values[i];
            sale.saled[i]--;
            sale.count--;
        }

    }

    private static int getTypeCount(Sale sale) {
        int count = 0;
        for (int i = 0; i < sale.saled.length; i++) {
            if (sale.saled[i] != 0) {
                count++;
            }
        }
        return count;
    }

    private static boolean isSmae(Sale s1, Sale s2) {
        for (int i = 0; i < s1.saled.length; i++) {
            if (s1.saled[i] != s2.saled[i]) {
                return false;
            }
        }
        return true;
    }

}
