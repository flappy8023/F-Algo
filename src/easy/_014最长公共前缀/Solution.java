package easy._014最长公共前缀;
/*编写一个函数来查找字符串数组中的最长公共前缀。

        如果不存在公共前缀，返回空字符串 ""。

        示例 1:

        输入: ["flower","flow","flight"]
        输出: "fl"
        示例 2:

        输入: ["dog","racecar","car"]
        输出: ""
        解释: 输入不存在公共前缀。*/

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String pref = "";
        if(strs.length==0)return pref;
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        for(int i=0;i<strs[0].length();i++){
            boolean isStartWith = true;
            for(String s:strs){
                if(!s.startsWith(strs[0].substring(0,i+1))){
                    isStartWith = false;
                    break;
                }
            }
            if(isStartWith){
                pref = strs[0].substring(0,i+1);
            }else {
                break;
            }
        }
        return pref;
    }

    /**纵向扫描
     * @param strs
     * @return
     * l e t
     * l e a f
     * l e f t
     */
    public String longestCommonPrefix1(String[] strs){
        if(null==strs||strs.length==0){
            return "";
        }
        //从第一列开始
        for(int i=0;i<strs[0].length();i++){
            char c = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                //如果当前行该列没有字符或者该列字符与第一行该列不一致，直接返回
                if(i==strs[j].length()||c!=strs[j].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.longestCommonPrefix(new String[]{"a"});
    }
}
