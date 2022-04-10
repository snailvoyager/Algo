package LeetCode.Medium;

public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3, 7));
    }

    static int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];

        return dfs(m-1, n-1);
    }

    public int dfs(int m, int n) {
        if (m ==0 && n == 0) {
            return 1;
        }

        if (memo[m][n] != 0) {
            return memo[m][n];
        }

        int up = 0;
        if (m > 0) {
            up = dfs(m - 1, n);
        }
        int down = 0;
        if (n > 0) {
            down = dfs(m, n-1);
        }

        return memo[m][n] = up + down;
    }
}
