package leetcode._239SlidingWindowMaximum;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description 单调队列
 * @createTime 2023年06月14日 15:08:00
 */
public class Solution {
    class MyQueue {
        Deque<Integer> deque = new LinkedList<>();

        public void pop(int x) {
            //当移出窗口的元素等于队首元素时，队首出队，其他情况不动
            if (!deque.isEmpty() && deque.peek() == x) {
                deque.poll();
            }
        }

        public void push(int x) {
            //当新进入窗口的元素大于队尾元素时，移除队尾元素，直到进入的元素小于等于队尾元素
            while (!deque.isEmpty() && x>deque.getLast()) {
                deque.removeLast();
            }
            deque.add(x);
        }

        public int front() {
            //队首元素永远是窗口中最大元素
            return deque.peek();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < k; i++) {
            myQueue.push(nums[i]);
        }
        int[] result = new int[nums.length - k + 1];
        result[0] = myQueue.front();
        for (int i = 1; i <= nums.length - k; i++) {
            myQueue.pop(nums[i - 1]);
            myQueue.push(nums[i + k - 1]);
            result[i] = myQueue.front();
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] res = s.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(res));
        Deque<Integer> deque = new LinkedList<>();
        deque.push(0);
        deque.add(1);
        deque.push(2);
        int a = deque.poll();
    }
}
