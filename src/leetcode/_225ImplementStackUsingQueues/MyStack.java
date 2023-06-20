package leetcode._225ImplementStackUsingQueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName MyStack.java
 * @Description TODO
 * @createTime 2023年06月20日 10:43:00
 */
class MyStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
      queue1.offer(x);
    }

    public int pop() {
        if (queue2.isEmpty()) {
            while (queue1.size() != 1) {
                queue2.offer(queue1.poll());
            }
            return queue1.poll();
        } else {
            while (queue2.size() != 1) {
                queue1.offer(queue2.poll());
            }
            return queue2.poll();
        }
    }

    public int top() {
        int top = pop();
        if (queue1.isEmpty()) {
            queue2.offer(top);
        } else {
            queue1.offer(top);
        }
        return top;
    }

    public boolean empty() {
        return queue2.isEmpty() && queue1.isEmpty();
    }
}