package od;

import java.util.Arrays;
import java.util.Scanner;

public class 字符串变换最小字符串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            char[] chars = input.toCharArray();
            Arrays.sort(chars);
            if (input.equals(new String(chars))) {
                System.out.println(input);
                return;
            }
            for (int i = 0; i < input.toCharArray().length; i++) {
                if (input.charAt(i) != chars[i]) {
                    int lastIndex = input.lastIndexOf(chars[i]);
                    char[] ss = input.toCharArray();
                    char temp = ss[lastIndex];
                    ss[lastIndex] = ss[i];
                    ss[i] = temp;
                    System.out.println(new String(ss));
                    return;
                }
            }
            System.out.println(input);
        }
    }
}
