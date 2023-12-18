package od;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class 字符串重新排序 {
    /**
     * https://fcqian.blog.csdn.net/article/details/128061871
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] strs = scanner.nextLine().split(" ");
            HashMap<String, Integer> countMap = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                char[] chars = strs[i].toCharArray();
                Arrays.sort(chars);
                strs[i] = new String(chars);
                countMap.put(strs[i], countMap.getOrDefault(strs[i], 0) + 1);
            }
            Arrays.sort(strs, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int repeatCount1 = countMap.get(o1);
                    int repeatCount2 = countMap.get(o2);
                    int length1 = o1.length();
                    int length2 = o2.length();
                    if (repeatCount1 != repeatCount2) {
                        return repeatCount2 - repeatCount1;
                    } else if (length1 != length2) {
                        return length1 - length2;
                    } else {
                        return o1.compareTo(o2);
                    }

                }
            });
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < strs.length; i++) {
                sb.append(strs[i]);
                if(i!=strs.length-1){
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
        }
    }
}
