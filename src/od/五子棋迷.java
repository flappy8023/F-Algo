package od;

import java.util.*;

public class 五子棋迷 {
    public static void main(String[] args) {
        /**
         * https://blog.csdn.net/qfc_128220/article/details/130766999
         */
        Scanner scanner = new Scanner(System.in);
        int cur = Integer.parseInt(scanner.nextLine());
        int[] lines = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //需要落子后长度得到增长
        int initialMaxLength = getInitMaxConstantLen(cur, lines);
        //记录落子位置及组成的连续长度
        List<int[]> ans = new ArrayList<>();
        //start-end内满足，全部是同一种颜色，长度不超过5
        int start = 0, end = 0;
        //落子位置
        int pos = 0;
        int zero = 0;
        while (end < lines.length) {
            //当前位置可以落子
            if (lines[end] == 0) {
                //还没落子
                zero++;

                //已经落子此时记录start-end之间的长度
                if (zero > 1 && end - start <= 5 && end - start > initialMaxLength) {
                    ans.add(new int[]{pos, end - start});
                }
                //已经落子重置落子状态，更新左指针到上次落子位置的右侧
                if (zero > 1) {
                    zero--;
                    start = pos + 1;
                }

                //更新落子位置
                pos = end;
                end++;

            } else if (cur != lines[end]) {
                //右指针指向的当前颜色不同，记录一下最长状态
                if (zero == 1 && end - start <= 5 && end - start > initialMaxLength) {
                    ans.add(new int[]{pos, end - start});
                }
                //重新计算连续区间，重置状态
                zero = 0;
                pos = -1;
                start = ++end;
            } else {
                end++;
            }
        }
        //
        if (zero == 1 && end - start <= 5 && end - start > initialMaxLength) {
            ans.add(new int[]{pos, end - start});
        }
        if (ans.isEmpty()) {
            System.out.println("-1");
        } else if (ans.size() == 1) {
            System.out.println(ans.get(0)[0]);
        } else {
            int mid = lines.length / 2;
            ans.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] == o2[1]) {
                        //最大长度相等，优先使用接近中间的较小下标
                        int midDiff1 = Math.abs(o1[0] - mid);
                        int midDiff2 = Math.abs(o2[0] - mid);
                        if (midDiff2 == midDiff1) {
                            return o1[0] - o2[0];
                        } else {
                            return midDiff1 - midDiff2;
                        }
                    } else {
                        return o2[1] - o1[1];
                    }
                }
            });
            System.out.println(ans.get(0)[0]);
        }
    }

    // 获取初始最大连续长度，即未落子前的最大连续长度
    public static int getInitMaxConstantLen(int color, int[] nums) {
        int maxLen = 0;

        int len = 0;
        for (int num : nums) {
            if (num != color) {
                maxLen = Math.max(maxLen, len);
                len = 0;
            } else {
                len++;
            }
        }

        return Math.max(maxLen, len);
    }

}
