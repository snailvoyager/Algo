package LeetCode.Medium;

public class WordSearch {
    boolean[][] visited;
    boolean result = false;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                search(board, i, j, word, 0);
            }
        }
        return result;
    }

    public void search(char[][] board, int i, int j, String word, int idx) {
        if (!visited[i][j] && word.length() > idx && board[i][j] == word.charAt(idx)) {
            if (word.length()-1 == idx) {
                result = true;
            }
            visited[i][j] = true;

            if (i > 0)
                search(board, i-1, j, word, idx+1);
            if (i < board.length-1)
                search(board, i+1, j, word, idx+1);
            if (j > 0)
                search(board, i, j-1, word, idx+1);
            if (j < board[i].length-1)
                search(board, i, j+1, word, idx+1);

            visited[i][j] = false;
        }
    }
}
