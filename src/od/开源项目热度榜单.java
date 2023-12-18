package od;

import java.util.*;

/**
 * @Auther: luweiming
 * @Date: 2023/12/18 21:33
 * @Description:
 */
public class 开源项目热度榜单 {
    /**
     * https://blog.csdn.net/qfc_128220/article/details/134386476
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] weights = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            int e = scanner.nextInt();
            int hot = a * weights[0] + b * weights[1] + c * weights[2] + d * weights[3] + e * weights[4];
            map.put(name, hot);
        }

        Map.Entry<String, Integer>[] entries = map.entrySet().toArray(Map.Entry[]::new);
        Arrays.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey().toLowerCase().compareTo(o2.getKey().toLowerCase());
                } else {
                    return o2.getValue() - o1.getValue();
                }
            }
        });
        for (int i = 0; i < entries.length; i++) {
            System.out.println(entries[i].getKey());
        }
    }
}
