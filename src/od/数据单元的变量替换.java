package od;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 数据单元的变量替换 {
    /**
     * 将一个csv格式的数据文件中包含有单元格引用的内容替换为对应单元格内容的实际值。
     * Comma seprated values（CSV）逗号分隔值，csv格式的数据文件使用逗号作为分隔符将各单位的内容进行分隔。
     * 输入描述
     * 1. 输入只有一行数据，用逗号分隔每个单元格，行尾没有逗号。最多26个单元格，对应编号A-Z。
     * 2. 每个单元格的内容包含字母和数字，以及使用<>分隔的单元格引用，例如：<A>表示引用第一个单元的值。
     * 3. 每个单元格的内容，在替换前和替换后均不超过100个字符。
     * 5. 引用单元格的位置不受限制，运行排在后面的单元格被排在前面的单元格引用。
     * 6. 不存在循环引用的情况，比如下面这种场景是不存在的：
     * A单元格：aCd<B>8u
     * B单元格：kAy<A>dzqo
     * 7. 不存在多重<>的情况，一个单元格只能引用一个其他单元格。比如下面这种场景是不存在的：
     * A单元格：aCd8u
     * B单元格：kAydzqo
     * C单元格：y<<A><B>>d
     * 输出描述：
     * 输出所有单元格展开的内容，单元格之间用逗号分隔。处理过程中出现错误时，输出字符串“-1”表示出错。
     * 示例1
     * 输入1,2<A>00
     * 输出1，2100
     * 说明
     * 第二个单元中有对A单元的引用，A单元格的值为1，替换时，将A单元的内容替代<A>的位置，并和其他内容合并。
     * 示例2
     * 输入<B>12,1
     * 输出
     * 112，1
     * 说明
     * 第一个单元中有对B单元的引用，B单元格的值为1，替换时，将第二个数据单元的内容替代<B>的位置，并和其他内容合并。
     * 示例3
     * 输入
     * <B<12,1
     * 输出
     * -1
     * 说明
     * 第一个单元中有错误的单元格引用方式，输出-1
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, String> letterReferences = new HashMap<>();
        while (scanner.hasNext()) {
            String input = scanner.next();
            String[] arr = input.split(",");
            StringBuilder sb = new StringBuilder();
            //首先记录单元格与内容映射关系
            for (int i = 0; i < arr.length; i++) {
                letterReferences.put((char) ('A' + i), arr[i]);
            }
            //处理单元格内的引用
            for (char key : letterReferences.keySet()) {
                String value = letterReferences.get(key);
                int left = value.indexOf("<");
                int right = value.indexOf(">");
                while (left != -1 || right != -1) {
                    if (left == -1 || right == -1 || left > right) {
                        System.out.println("-1");
                        return;
                    } else if (right - left > 2) {//<>中间不止一个字符
                        System.out.println("-1");
                        return;
                    } else {
                        char reference = value.charAt(left + 1);
                        //引用不存在的单元格  、自引用报错
                        if (!letterReferences.containsKey(reference)||key==reference) {
                            System.out.println("-1");
                            return;
                        }
                        value = value.substring(0, left) + letterReferences.get(reference) + value.substring(right + 1);
                        left = value.indexOf("<");
                        right = value.indexOf(">");
                    }
                }
                letterReferences.put(key, value);
            }
            for (char c : letterReferences.keySet()) {
                sb.append(letterReferences.get(c)).append(",");
            }
            System.out.println(sb.substring(0, sb.length() - 1));
        }
    }


}
