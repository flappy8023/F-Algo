package adv;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName NodeAccessProbability.java
 * @Description https://blog.csdn.net/qq_42837890/article/details/125151135?spm=1001.2014.3001.5502
 * @createTime 2023年05月25日 18:12:00
 */
public class NodeAccessProbability {
    private static int time = 0;
   static Map<Integer,Float> pMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nodeCount = scanner.nextInt();
        int edgeCount = scanner.nextInt();
        time = scanner.nextInt();
        float[][] edges = new float[nodeCount + 1][nodeCount + 1];
        for (int i = 0; i < edgeCount; i++) {
            edges[scanner.nextInt()][scanner.nextInt()] = scanner.nextFloat();
        }
        boolean[] visit = new boolean[nodeCount + 1];
        visit[1] = true;
        dfs(1, 1, 0, edges, nodeCount, visit);
        float maxP = 0.0f;
        Map.Entry<Integer,Float> max = null;
        for (Map.Entry<Integer,Float> entry:pMap.entrySet()){
            if(entry.getValue()>maxP){
                maxP = entry.getValue();
                max = entry;
            }
        }
        System.out.println(max.getKey()+" "+max.getValue());

    }

    private static void dfs(int node, float probability, int t, float[][] edges, int nodeCount, boolean[] visit) {
        if (t == time) {
            float op = pMap.get(node)==null?0f:pMap.get(node);
            pMap.put(node,op+probability);
            return;
        }
        boolean find = false;
        for (int j = 1; j < nodeCount + 1; j++) {
            if (edges[node][j] != 0.0f/* && !visit[j]*/) {
                find = true;
//                visit[j] = true;
                dfs(j, probability * edges[node][j], t + 10, edges, nodeCount, visit);
//                visit[j] = false;
            }
        }
        if (!find) {
            dfs(-1, probability, t + 10, edges, nodeCount, visit);
        }
    }
}
