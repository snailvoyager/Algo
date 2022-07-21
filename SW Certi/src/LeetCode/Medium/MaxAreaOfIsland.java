package LeetCode.Medium;

import java.util.Arrays;

public class MaxAreaOfIsland {
    int[] parent;
    int[] rank;
    public int maxAreaOfIsland(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        parent = new int[N*M];
        rank = new int[N*M];

        Arrays.fill(parent, -1);

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (grid[i][j] == 1) {
                    parent[i*M+j] = i*M+j;
                    rank[i*M+j] = 1;
                    if (j-1 > -1 && grid[i][j-1] == 1) {
                        union(i*M+j, i*M+(j-1));
                    }

                    if (i-1 > -1 && grid[i-1][j] == 1) {
                        union(i*M+j, (i-1)*M+j);
                    }

                }
            }
        }

        int result = 0;
        for (int i : rank)
            if (i != -1)
                result = Math.max(result, i);

        return result;
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY)
            return;

        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;          //사이즈가 높은 쪽으로
            rank[rootX] += rank[rootY];     //사이즈 합하기
        } else {
            parent[rootX] = rootY;
            rank[rootY] += rank[rootX];
        }
    }
}
