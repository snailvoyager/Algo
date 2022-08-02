package LeetCode.Medium;

import java.util.Arrays;

public class Search2DMatrix {
    public static void main(String[] args) {
        System.out.println(Arrays.binarySearch(new int[]{1}, 1));
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int idx = 0;
        for (int i=1; i<matrix.length; i++) {
            if (matrix[i][0] > target) {
                idx = i-1;
                break;
            }
            idx = i;
        }
        return Arrays.binarySearch(matrix[idx], target) > -1;
    }
}
