package LeetCode.Medium;

import java.util.*;

public class NumbersOfIslands {
    public int numIslands_fs(char[][] grid) {
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

    public int numIslands(char[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        int[] parent = new int[N * M];
        Arrays.fill(parent, -1);

        for (int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == '1') {
                    parent[i * M + j] = i * M + j;      // 최초 부모는 자기 자신
                }
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (grid[i][j] == '1') {
                    //parent[i*grid.length+j] = i*grid.length+j;      // 최초 부모는 자기 자신

                    if (i + 1 < N && grid[i+1][j] == '1') {
                        union(parent, i*M+j, (i+1)*M+j);
                    }
                    if (j+1 < M && grid[i][j+1] == '1') {
                        union(parent, i*M+j, i*M+(j+1));
                    }
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i=0; i<parent.length; i++) {
            if (parent[i] != -1)
                set.add(find(parent, i));
        }

        return set.size();
    }

    public int find(int[] parent, int z) {
        if (parent[z] != z)
            parent[z] = find(parent, parent[z]);
        return parent[z];
    }

    public void union(int[] parent, int x, int y) {
        int xParent = find(parent, x);
        int yParent = find(parent, y);

        parent[yParent] = parent[xParent];
    }
}
