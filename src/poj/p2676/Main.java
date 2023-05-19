package poj.p2676;

import java.util.Scanner;

public class Main {
	// boolean[i][j]第i行数字j是否出现
	static boolean[][] rows = new boolean[9][10];
	// boolean[m][n]第m列数字n是否出现
	static boolean[][] cols = new boolean[9][10];
	// boolean[x][y]第x个小九宫格数字y是否出现
	static boolean[][] grids = new boolean[9][10];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int cases = scanner.nextInt();
			scanner.nextLine();
			for (int index = 0; index < cases; index++) {
				int[][] nums = new int[9][9];
				for (int i = 0; i < 9; i++) {
					
					char[] line = scanner.nextLine().toCharArray();
					for (int j = 0; j < line.length; j++) {
						int n = line[j]-'0';
						nums[i][j] = n;
						if (nums[i][j] != 0) {
							rows[i][nums[i][j]] = true;
							cols[j][nums[i][j]] = true;
							grids[getGridIndex(i, j)][nums[i][j]] = true;
						}
					}
				}
				dfs(nums, 0, 0);
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						System.out.print(nums[i][j]);
					}
					System.out.println();
				}
			}
		}

	}

	private static int getGridIndex(int i, int j) {
		return i / 3 * 3 + j / 3;
	}

	private static boolean dfs(int[][] nums, int x, int y) {
		if (x == 9)
			return true;

		boolean flag = false;
		if (nums[x][y] != 0) {
			if (y == 8) {
				flag = dfs(nums, x + 1, 0);
			} else {
				flag = dfs(nums, x, y + 1);
			}
			return flag;
		} else {
			int grid = getGridIndex(x, y);
			for (int i = 1; i <= 9; i++) {
				if (rows[x][i] || cols[y][i] || grids[grid][i])
					continue;
				nums[x][y] = i;
				rows[x][i] = true;
				cols[y][i] = true;
				grids[grid][i] = true;
				boolean fl = false;
				if (y == 8) {
					fl = dfs(nums, x + 1, 0);
				} else {
					fl = dfs(nums, x, y + 1);
				}
				if (!fl) {
					rows[x][i] = false;
					nums[x][y] = 0;
					cols[y][i] = false;
					grids[grid][i] = false;

				} else
					return true;
			}
		}
		return false;
	}
}
