package od;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 处理器问题 {
    /**
     * https://fcqian.blog.csdn.net/article/details/128048132
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            Integer[] integers = Arrays.stream(input.substring(1, input.length() - 1).split(",")).map(String::trim).filter(str -> !"".equals(str))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
            int num = Integer.parseInt(scanner.next());
            System.out.println(getCombines(integers, num));
        }
    }

    private static String getCombines(Integer[] nums, int count) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Arrays.sort(nums);
        for (Integer num : nums) {
            if (num < 4) {
                list1.add(num);
            } else {
                list2.add(num);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int length1 = list1.size();
        int length2 = list2.size();
        switch (count) {
            case 1:
                if (length1 == 1 || length2 == 1) {
                    if (length1 == 1) backTracking(list1, 0, 1, path, ans);
                    if (length2 == 1) backTracking(list2, 0, 1, path, ans);
                } else if (length1 == 3 || length2 == 3) {
                    if (length1 == 3) backTracking(list1, 0, 1, path, ans);
                    if (length2 == 3) backTracking(list2, 0, 1, path, ans);
                } else if (length1 == 2 || length2 == 2) {
                    if (length1 == 2) backTracking(list1, 0, 1, path, ans);
                    if (length2 == 2) backTracking(list2, 0, 1, path, ans);
                } else if (length1 == 4 || length2 == 4) {
                    if (length1 == 4) backTracking(list1, 0, 1, path, ans);
                    if (length2 == 4) backTracking(list2, 0, 1, path, ans);
                }
                break;
            case 2:
                if (length1 == 2 || length2 == 2) {
                    if (length1 == 2) backTracking(list1, 0, 2, path, ans);
                    if (length2 == 2) backTracking(list2, 0, 2, path, ans);
                } else if (length1 == 4 || length2 == 4) {
                    if (length1 == 4) backTracking(list1, 0, 2, path, ans);
                    if (length2 == 4) backTracking(list2, 0, 2, path, ans);
                } else if (length1 == 3 || length2 == 3) {
                    if (length1 == 3) backTracking(list1, 0, 2, path, ans);
                    if (length2 == 3) backTracking(list2, 0, 2, path, ans);
                }
                break;
            case 4:
                if (length1 == 4 || length2 == 4) {
                    if (length1 == 4) backTracking(list1, 0, 4, path, ans);
                    if (length2 == 4) backTracking(list2, 0, 4, path, ans);
                }
                break;
            case 8:
                if (length1 == 4 && length2 == 4) {
                    ans.add(Arrays.stream(nums).collect(Collectors.toList()));
                }
                break;
        }
        return ans.toString();
    }

    private static void backTracking(List<Integer> list, int index, int count, List<Integer> path, List<List<Integer>> ans) {
        if (count == path.size()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < list.size(); i++) {
            path.add(list.get(i));
            backTracking(list, i + 1, count, path, ans);
            path.remove(path.size() - 1);
        }
    }
}
