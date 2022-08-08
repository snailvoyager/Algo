package coding;

import java.util.Arrays;

public class CP211031C {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] visit;

    public static void main(String[] args) {
        int[][] board = {{3,2,3,2},{2,1,1,2},{1,1,2,1},{4,1,1,1}};
        for (int i=0; i<board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println(solution(board));

        for (int i=0; i<board.length; i++) {
            System.out.println(Arrays.toString(visit[i]));
        }
    }

    static int Answer;
    public static int solution(int[][] board) {
        visit = new int[board.length][board[0].length];

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                dfs(board, i, j, 0);

            }
        }
        if (Answer == 1) {
            return -1;
        }
        return Answer;
    }

    public static void dfs(int[][] board, int x, int y, int n) {
        n++;
        visit[x][y] = 1;

        for(int i=0; i<4; i++) {		//상하좌우 체크
            int xx = x + dx[i];
            int yy = y + dy[i];

            if(xx>=0 && xx<board.length && yy>=0 && yy<board[x].length
                    && visit[xx][yy] == 0
                    && board[xx][yy] == board[x][y]) {
                //System.out.println("DFS : " + xx + ", " + yy + " " + flag);
                dfs(board, xx, yy, n);
            }
        }
        visit[x][y] = 0;
        if (Answer < n) {
            Answer = n;
        }
    }
}
