package coding;

public class TV220904C {
    //BOJ 8394
    public static void main(String[] args) {
        int N = 4;
        int answer = 0;
        int[][] dp = new int[N+1][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 1;
        dp[1][1] = 0;

        for (int i=2; i<=N; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
            dp[i][1] = dp[i-2][0] + dp[i-2][1];
        }

        System.out.println(dp[N][0] + dp[N][1]);
    }
}
