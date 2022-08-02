package LeetCode.Medium;

import java.util.Arrays;

public class Search2DMatrix2 {
    public boolean searchMatrix_binarySearch(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            if (Arrays.binarySearch(ints, target) > -1) {
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length-1;

        while (row < matrix.length && col > -1) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else if (matrix[row][col] > target) {
                col--;
            }
        }
        return false;
    }
}
