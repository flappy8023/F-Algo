package od;

import java.util.*;

public class 会议室占用时间 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] input = new int[n][2];
        for (int i = 0; i < n; i++) {
            input[i][0] = scanner.nextInt();
            input[i][1] = scanner.nextInt();
        }
        Arrays.sort(input, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            if (i == 0) {
                ans.add(input[0]);
            } else {
                //上个区间
                int[] last = ans.get(ans.size() - 1);
                if (input[i][0] > last[1]) {
                    ans.add(input[i]);
                } else {
                    //当前区间左边大于等于上个区间的右侧，替换上个区间的右侧
                    last[1] = Math.max(input[i][1],last[1]);
                }
            }
        }
        for (int[] an : ans) {
            System.out.println(an[0] + " " + an[1]);
        }
    }
}
