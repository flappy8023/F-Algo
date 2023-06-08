package leetcode._200NumberOfIslands;

/**
 * @author luweiming
 * @version 1.0.0
 * @ClassName Solution.java
 * @Description TODO
 * @createTime 2023年05月25日 11:07:00
 */
public class Solution {
    private boolean[][] visit = null;

    public int numIslands(char[][] grid) {
        visit = new boolean[grid.length][grid[0].length];
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visit[i][j]) {
                    dfs(i, j, grid);
                    result++;
                }
            }
        }
        return result;
    }

    private void dfs(int r, int c, char[][] grid) {
        if (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && visit[r][c]) return ;
        if (r == grid.length || c == grid[0].length || r < 0 || c < 0 || grid[r][c] == '0') {
            return;
        }
        if (grid[r][c] == '1') {
            visit[r][c] = true;
        }

        dfs(r + 1, c, grid);
        dfs(r, c + 1, grid);
        dfs(r - 1, c, grid);
        dfs(r, c - 1, grid);

    }

    public static void main(String[] args) {
        char[][] nums = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        Solution solution = new Solution();

        System.out.println(solution.numIslands(nums));
    }
}
