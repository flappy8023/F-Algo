package leetcode.easy._155最小栈;

import java.util.Stack;

/*设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

        push(x) —— 将元素 x 推入栈中。
        pop() —— 删除栈顶的元素。
        top() —— 获取栈顶元素。
        getMin() —— 检索栈中的最小元素。

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/min-stack
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;//专门用来保存最小值


    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    //每次入栈，同步保存当前入栈元素与minstack栈顶元素中较小的一个到minstack中
    public void push(int x) {
        stack.push(x);
        if (!minStack.isEmpty()) {
            minStack.push(Math.min(minStack.peek(), x));
        } else {
            minStack.push(x);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if (!minStack.isEmpty())
            return minStack.peek();
        else return 0;
    }
}

class MinStack1 {
    private Stack<Integer> stack;
    private int min = Integer.MAX_VALUE;

    public MinStack1() {
        stack = new Stack<>();
    }

    //当出现新的最小值时将上个最小值先压入栈,更新最小值
    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        //当要出栈的元素是最小值时，连续出栈两次，并将上次最小值赋值当前
        if (min == stack.pop()) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return top();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
