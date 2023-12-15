package od;

import java.util.Scanner;
import java.util.StringJoiner;

public class 密码输入检测 {
    /**
     * 给定用户密码输入流input，输入流中字符'<'表示退格，可以清除前一个输入的字符，请你编写程序，输出最终得到的密码字符，并判断密码是否满足如下的密码安全要求。
     * 密码安全要求如下:
     * 1.密码长度>=8
     * 2.密码至少需要包含1个大写字母
     * 3.密码至少需要包含1个小写字母
     * 4.密码至少需要包含1个数字
     * 5.密码至少需要包含1个字母和数字以外的非空白特殊字符
     * 注意空串退格后仍然为空串，且用户输入的字符串不包含<’字符和空白字符
     * 输入描述
     * 用一行字符串表示输入的用户数据，输入的字符串中“字符标识退格，用户输入的字符串不包含空白字符.
     * 输出描述
     * 输出经过程序处理后，输出的实际密码字符串，并输出改密码字符串是否满足密码安全要求。两者间由,分隔
     * 示例1
     * 输入
     * ABC<c89%000<
     * 输出
     * ABc89%00,true
     * 说明
     * 解释: 多余的C和0由于退格被去除,最终用户输入的密码为ABc89%00，且满足密码安全要求，输出true
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            char[] chars = input.toCharArray();
            String finalPwd = "";
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != '<') {
                    finalPwd += chars[i];
                } else {
                    finalPwd = finalPwd.substring(0, finalPwd.length());
                }
            }
            boolean containsUpper = false;
            boolean containsLittle = false;
            boolean containsNumber = false;

            for (int i = 0; i < finalPwd.length(); i++) {
                if (Character.isUpperCase(finalPwd.charAt(i))) {
                    containsUpper = true;
                } else if (Character.isLowerCase(finalPwd.charAt(i))) {
                    containsLittle = true;
                } else if (Character.isDigit(finalPwd.charAt(i))) {
                    containsNumber = true;
                }
            }
            if (containsNumber && containsLittle && containsUpper & finalPwd.length() >= 8) {
                System.out.println(finalPwd + ",true");
            } else {
                System.out.println(finalPwd + ",false");
            }
        }
    }
}
