class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> list = new LinkedList<>();
        int row = 0, col = 0, cnt = 0, idx = 1;
        
        while (idx <= m*n) {
            //right
            for (int i=col; i<n-cnt; i++) {
                list.add(matrix[row][i]);
                col = i;
                idx++;
            }
            if (idx > m*n)
                break;
            row++;
            //down
            for (int i=row; i<m-cnt; i++) {
                list.add(matrix[i][col]);
                row = i;
                idx++;
            }
            if (idx > m*n)
                break;
            col--;
            //left
            for (int i=col; i>=cnt; i--) {
                list.add(matrix[row][i]);
                col = i;
                idx++;
            }
            if (idx > m*n)
                break;
            row--;
            //up
            for (int i=row; i>cnt; i--) {
                list.add(matrix[i][col]);
                row = i;
                idx++;
            }
            if (idx > m*n)
                break;
            col++;
            cnt++;
        }
        
        
        return list;
    }
}