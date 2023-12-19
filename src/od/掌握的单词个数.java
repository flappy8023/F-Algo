package od;

import java.util.*;

public class 掌握的单词个数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = scanner.nextLine();
        }
        char[] chars = scanner.nextLine().toCharArray();
        List<Character> characters = new LinkedList<>();
        int superCount = 0;
        for (int i = 0; i < chars.length; i++) {
           characters.add(chars[i]);
           if(chars[i]=='?'){
               superCount++;
           }
        }
        int ans = 0;
        for (String word : words) {
            char[] cs = word.toCharArray();
            List<Character> copy = new ArrayList<>(characters);
            //chars中缺少的字符个数
            int need = 0;
            for (char c : cs) {
                boolean contains = copy.remove((Character) c);
                if(!contains){
                    need++;
                }
            }
            //缺少的字符足够用?补齐
            if(need<=superCount){
                ans++;
            }
        }
        System.out.println(ans);


    }
}
