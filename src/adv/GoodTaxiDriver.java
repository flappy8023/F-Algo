package adv;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName GoodTaxiDriver.java
 * @Description https://blog.csdn.net/qq_42837890/article/details/125264393?spm=1001.2014.3001.5502
 * @createTime 2023年05月24日 10:25:00
 */
public class GoodTaxiDriver {
    private static float minTime = Integer.MAX_VALUE;
    private static List<Integer> result = null;
    private static List<Integer> finalResult = null;

    static class Road {
        int startCity;
        int endCity;
        int limit;
        int length;

        public Road(int s, int e, int v, int l) {
            startCity = s;
            endCity = e;
            limit = v;
            length = l;

        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int cityCount = scanner.nextInt();
            int roadCount = scanner.nextInt();
            int targetCity = scanner.nextInt();
            Road[] roads = new Road[roadCount];
            for (int j = 0; j < roadCount; j++) {
                roads[j] = new Road(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            }
            result = new ArrayList<>();
            minTime = Integer.MAX_VALUE;
            boolean[] visit = new boolean[cityCount];
            result.add(0);
            visit[0] = true;
            dfs(roads, visit, 0, targetCity, 0.0f, 70);
            System.out.printf("#" + (i + 1));
            for (int m = 0; m < finalResult.size(); m++) {
                System.out.print(" " + finalResult.get(m));
            }
        }
    }

    /**
     * @param roads
     * @param visit
     * @param cityIndex 本次在的城市下标
     * @param targetCity 目标城市下标
     * @param time 已用时间
     * @param speed  上次的速度
     */
    private static void dfs(Road[] roads, boolean[] visit, int cityIndex, int targetCity, float time, int speed) {
        if (time > minTime) return;
        if (cityIndex == targetCity) {
            if (time <= minTime) {
                minTime = time;
                finalResult = new ArrayList<>(result);
            }
            return;
        }
        for (int i = 0; i < roads.length; i++) {
            if (visit[roads[i].endCity]) continue;
            if (roads[i].startCity == cityIndex) {
                visit[roads[i].endCity] = true;
                result.add(roads[i].endCity);
                //本次道路不限速保持上次的速度
                if (roads[i].limit == 0) {
                    dfs(roads, visit, roads[i].endCity, targetCity, time + ((float) roads[i].length / speed), speed);
                }
                //本次限速使用限制速度
                else {
                    dfs(roads, visit, roads[i].endCity, targetCity, time + ((float) roads[i].length / roads[i].limit), roads[i].limit);
                }
                result.remove(result.size() - 1);
                visit[roads[i].endCity] = false;
            }
        }
    }

}
