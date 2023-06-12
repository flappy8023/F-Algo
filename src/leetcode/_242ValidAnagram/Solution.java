package leetcode._242ValidAnagram;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月12日 10:10:00
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] letters = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            letters[index]++;
        }
        char[] charsT = t.toCharArray();
        for (int i = 0; i < charsT.length; i++) {
            int index = charsT[i] - 'a';
            letters[index]--;
        }
        for (int i = 0; i < letters.length; i++) {

            if (letters[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        sl.isAnagram("aword", "roawd");
    }
}
