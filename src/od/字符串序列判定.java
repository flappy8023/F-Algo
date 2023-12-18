package od;

import java.util.Scanner;

public class 字符串序列判定 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String l = scanner.nextLine();
        int sIndex = 0;
        int lIndex = 0;
        while (sIndex < s.length() && lIndex < l.length()) {
            if (s.charAt(sIndex) == l.charAt(lIndex)) {
                sIndex++;
            }
            lIndex++;
        }
        if (sIndex == s.length()) {
            System.out.println((lIndex-1) + "");
        } else {
            System.out.println("-1");
        }
    }
}
