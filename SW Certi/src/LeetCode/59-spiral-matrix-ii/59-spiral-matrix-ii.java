class Solution {
    public int[][] generateMatrix(int n) {
        int[][] M = new int[n][n];
        int idx = 1, cnt = 0, row =0, col = 0;
        while (idx <= n*n) {
            //right
            for (int i=col; i<n-cnt; i++) {
                M[row][i] = idx++;
                col = i;
            }
            row++;
            //down
            for (int i=row; i<n-cnt; i++) {
                M[i][col] = idx++;
                row = i;
            }
            col--;
            //left
            for (int i=col; i>=cnt; i--) {
                M[row][i] = idx++;
                col = i;
            }
            row--;
            //up
            for (int i=row; i>cnt; i--) {
                M[i][col] = idx++;
                row = i;
            }
            col++;
            cnt++;
        }

        return M;
    }
}