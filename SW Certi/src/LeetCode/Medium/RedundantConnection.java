package LeetCode.Medium;

public class RedundantConnection {
    int[] parent;
    int[] result = new int[2];
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n+1];

        for (int i=0; i<parent.length; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

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

        if (rootX == rootY) {
            result[0] = x;
            result[1] = y;
            return;
        }
        parent[rootX] = rootY;
    }
}
