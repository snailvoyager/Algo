package LeetCode.Medium;

public class MinimumPathSum {
    static int[][] memo;

    public int minPathSum(int[][] grid) {
        int m = grid.length-1;
        int n = grid[0].length-1;
        memo = new int[m+1][n+1];

        return dfs(grid, m, n);
    }

    public int dfs(int[][] grid, int m, int n) {
        if (m == 0 && n ==0)
            return grid[m][n];

        if (memo[m][n] != 0) {
            return memo[m][n];
        }

        int up = 999;
        int left = 999;
        if (m > 0) {
            up = grid[m][n] + dfs(grid, m-1, n);
        }
        if (n > 0) {
            left = grid[m][n] + dfs(grid, m, n-1);
        }

        return memo[m][n] = Math.min(up, left);
    }
}
