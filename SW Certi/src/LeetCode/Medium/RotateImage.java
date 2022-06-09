package LeetCode.Medium;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i=0; i<n-1; i++) {       //대각선축 교환
            for (int j=i+1; j<n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i=0; i<n; i++) {         //수직축 교환
            for (int j=0; j<n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
}
