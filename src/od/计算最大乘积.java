package od;

import java.util.*;

public class 计算最大乘积 {
    private static int max = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] strings = scanner.nextLine().split(",");
            List<HashSet<Character>> list = new ArrayList<>();
            int max = 0;
            for (String string : strings) {
                HashSet<Character> hashSet = new HashSet<>();

                for (int j = 0; j < string.length(); j++) {
                    hashSet.add(string.charAt(j));
                }
                list.add(hashSet);
            }
            for (int i = 0; i < strings.length; i++) {
                for (int j = 1; j < strings.length; j++) {
                    if (!repeatLetter(list.get(i), list.get(j))) {
                        max = Math.max(max, strings[i].length() * strings[j].length());
                    }
                }
            }
            System.out.println(max + "");
            getResult(strings);
        }
    }

    private static boolean repeatLetter(HashSet<Character> set1, HashSet<Character> set2) {
        for (Character c : set1) {
            if (set2.contains(c)) {
                return true;
            }
        }
        return false;
    }

    public static int getResult(String[] words) {
        int ans = 0;

        int n = words.length;
        int[] bits = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                bits[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((bits[i] & bits[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }

        return ans;

    }
}

