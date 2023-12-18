package od;

import java.util.*;

/**
 * @Auther: luweiming
 * @Date: 2023/12/18 21:51
 * @Description:
 */
public class 考古学家 {
    /**
     * https://fcqian.blog.csdn.net/article/details/127711587
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] strs = scanner.nextLine().split(" ");
        HashSet<String> ans = new HashSet<>();
        List<String> sb = new ArrayList<>();
        boolean[] visit = new boolean[strs.length];
        Arrays.sort(strs);
        backTracking(strs, visit, sb, ans);
        ans.stream().sorted(String::compareTo).forEach(System.out::println);
    }

    public static void backTracking(String[] letters, boolean[] visit, List<String> path, HashSet<String> ans) {
        if (path.size() == letters.length) {
            StringBuilder sb = new StringBuilder();
            path.forEach(sb::append);
            ans.add(sb.toString());
            return;
        }
        for (int i = 0; i < letters.length; i++) {
            if (visit[i] || (i > 0 && letters[i].equals(letters[i - 1]) && !visit[i - 1])) {
                continue;
            }
            visit[i] = true;
            path.add(letters[i]);
            backTracking(letters, visit, path, ans);
            visit[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
