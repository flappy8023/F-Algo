package leetcode._058最后一个单词的长度;
/*给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。

        如果不存在最后一个单词，请返回 0 。

        说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。

         

        示例:

        输入: "Hello World"
        输出: 5*/

public class Solution {
    public int lengthOfLastWord(String s) {
        int left = 0, right = 0;
        int length = 0;
        while (left < s.length()) {
            if (s.charAt(left) == ' ') {
                left++;
                continue;
            }
            length = 0;
            right = left;
            while (right < s.length()) {
                if (s.charAt(right) != ' ') {
                    length++;
                }else {
                    break;
                }
                right++;
            }
            left=right;
        }
        return length;
    }
    public int lengthOfLastWord1(String s){
        int length = 0,lastL = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                length++;
                lastL = length;
            }else {
                length=0;
            }
        }
        return lastL;
    }
    //倒序查找
    public int lengthOfLastWord2(String s){
        int length = 0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==' '){
                if(length>0)return length;
            }else {
                length++;
            }

        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord("Hello World"));
        System.out.println(new Solution().lengthOfLastWord2("Hello World"));

    }
}
