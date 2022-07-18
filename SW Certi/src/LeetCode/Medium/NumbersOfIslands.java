package LeetCode.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class NumbersOfIslands {
    public int numIslands(char[][] grid) {
        int result = 0;

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }

        return result;
    }

    public void dfs(char[][] grid, int x, int y) {
        if (x + 1 < grid.length && grid[x+1][y] == '1') {
            grid[x+1][y] = '0';
            dfs(grid, x+1, y);
        }
        if (x - 1 > -1 && grid[x-1][y] == '1') {
            grid[x-1][y] = '0';
            dfs(grid, x-1, y);
        }
        if (y + 1 < grid[x].length && grid[x][y+1] == '1') {
            grid[x][y+1] = '0';
            dfs(grid, x, y+1);
        }
        if (y - 1 > -1 && grid[x][y-1] == '1') {
            grid[x][y-1] = '0';
            dfs(grid, x, y-1);
        }
    }

    class Node {
        int x;
        int y;
        Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void bfs (char[][] grid, int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.x + 1 < grid.length && grid[node.x+1][node.y] == '1') {
                grid[node.x+1][node.y] = '0';
                q.offer(new Node(node.x+1, node.y));
            }
            if (node.x - 1 > -1 && grid[node.x-1][node.y] == '1') {
                grid[node.x-1][node.y] = '0';
                q.offer(new Node(node.x-1, node.y));
            }
            if (node.y + 1 < grid[node.x].length && grid[node.x][node.y+1] == '1') {
                grid[node.x][node.y+1] = '0';
                q.offer(new Node(node.x, node.y+1));
            }
            if (node.y - 1 > -1 && grid[node.x][node.y-1] == '1') {
                grid[node.x][node.y-1] = '0';
                q.offer(new Node(node.x, node.y-1));
            }
        }
    }
}
