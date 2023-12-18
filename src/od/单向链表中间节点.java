package od;

import java.util.*;

public class 单向链表中间节点 {
    public static void main(String[] args) {
        /**
         * https://fcqian.blog.csdn.net/article/details/128049270
         */
        Scanner scanner = new Scanner(System.in);
        String headAddr = scanner.next();
        int n = scanner.nextInt();
        HashMap<String,String[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String addr = scanner.next();
            String value = scanner.next();
            String next = scanner.next();
            map.put(addr,new String[]{value,next});
        }
        String[] node = map.get(headAddr);
        List<String> list = new ArrayList<>();
        while (node!=null){
            String value = node[0];
            String next = node[1];
            list.add(value);
            node = map.get(next);
        }
        System.out.println(list.get(list.size()/2));
    }


}
