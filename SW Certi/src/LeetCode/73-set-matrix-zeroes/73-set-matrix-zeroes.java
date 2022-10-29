class Solution {
    public class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void setZeroes(int[][] matrix) {
        Queue<Node> q = new LinkedList<>();
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    q.offer(new Node(i, j));
                }
            }
        }
        while (!q.isEmpty()) {
            Node node = q.poll();
            setMatrix(matrix, node.x, node.y);
        }
        
    }
    
    public void setMatrix(int[][] matrix, int x, int y) {
        for (int i=0; i<matrix[x].length; i++) {
            matrix[x][i] = 0;
        }
        
        for (int i=0; i<matrix.length; i++) {
            matrix[i][y] = 0;
        }
    }
}