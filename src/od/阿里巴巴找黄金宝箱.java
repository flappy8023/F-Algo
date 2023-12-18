package od;

import java.util.*;

public class 阿里巴巴找黄金宝箱 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer[] nums = Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).toArray(Integer[]::new);
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Map.Entry<Integer, Integer>[] entries = map.entrySet().toArray(Map.Entry[]::new);
        Arrays.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        int end = 0;
        int destroyed = 0;
        int half = nums.length / 2;
        while (destroyed < half) {
            destroyed += entries[end].getValue();
            end++;
        }
        System.out.println(end);
    }
}
