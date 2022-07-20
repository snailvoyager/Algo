package LeetCode.Medium;

import java.util.HashSet;
import java.util.Set;

public class NumberOfProvinces {
    int[] parent;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n];

        for (int i=0; i<n; i++) {
            parent[i] = i;
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i : parent) {
            set.add(find(i));
        }

        return set.size();
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int xP = find(x);
        int yP = find(y);

        if (xP != yP) {
            parent[xP] = yP;
        }
    }
}
