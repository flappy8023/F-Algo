package leetcode._383RansonNote;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年06月12日 15:59:00
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for (char c : magazine.toCharArray()) {
            map[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (map[c - 'a'] > 0) {
                map[c - 'a']--;
            } else {
                return false;
            }
        }
        return true;
    }
}
