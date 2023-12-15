package od;

import java.util.*;

public class 最短木板长度 {
    public static void main(String[] args) {
        /**
         * https://fcqian.blog.csdn.net/article/details/128249227
         */
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] line1 = scanner.nextLine().split(" ");
            int n = Integer.parseInt(line1[0]);
            int m = Integer.parseInt(line1[1]);
            Integer[] arr = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
            System.out.println(getLength(arr, n, m));

        }
    }

    public static int getLength(Integer[] arr, int n, int m) {
        //key 木板长度  value  数量
        Map<Integer, Integer> map = new TreeMap<>();
        for (Integer i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        //优先级队列根据长度排序
        Queue<Integer[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        for (Integer i : map.keySet()) {
            queue.offer(new Integer[]{i, map.get(i)});
        }
        while (m > 0) {
            //木板一样长，平均分配m到每一个木板
            if (queue.size() == 1) {
                Integer[] item = queue.poll();
                int length = item[0];
                int count = item[1];
                return length + m / count;
            }
            //看看m够不够补齐最短的木板到与次短木板一样长
            Integer[] min = queue.poll();
            Integer[] secondMin = queue.peek();
            int minCount = min[1];
            int diff = secondMin[0] - min[0];
            int need = minCount * diff;
            //正好能补齐，就是次短的长度
            if (need == m) {
                return secondMin[0];
            } else if (m < need) {//m不够把最短全部补成次短，均分
                return min[0] + m / min[1];
            }else {//m把最短补成次短还有剩余，就重新计算m，次短变成最短，更新数量
                m = m-need;
                secondMin[1] +=minCount;
            }
        }
        return queue.peek()[0];
    }
}
