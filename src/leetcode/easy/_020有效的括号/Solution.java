package leetcode.easy._020有效的括号;

import java.util.Stack;

/*给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

        有效字符串需满足：

        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
        注意空字符串可被认为是有效字符串

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/valid-parentheses
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character character : s.toCharArray()) {
            if ('('==character||'{'==character||'['==character) {
                stack.push(character);
            } else {
                if (!stack.isEmpty()) {
                    if(character=='}'){
                        if(stack.peek()!='{'){
                            return false;
                        }else {
                            stack.pop();
                        }
                    }
                    if(character==']'){
                        if(stack.peek()=='['){
                            stack.pop();
                        }else {
                            return false;
                        }
                    }
                    if(character==')'){
                        if(stack.peek()=='('){
                            stack.pop();
                        }else {
                            return false;
                        }
                    }
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * @param s
     * @return
     */
    public boolean isValid1(String s){
        Stack<Character> stack = new Stack<>();
        for(Character c:s.toCharArray()){
            //遇到左括号入栈右括号，遇到右括号直接出栈，
            if(c=='['){
                stack.push(']');
            }else if(c=='{'){
                stack.push('}');
            }else if(c=='('){
                stack.push(')');
            }else if(stack.isEmpty()||stack.pop()!=c){//出栈元素与当前不相等说明不配对
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.isValid("(])"));
//        System.out.println(s.isValid("[}"));
        System.out.println(s.isValid("{[()]}"));
    }
}
