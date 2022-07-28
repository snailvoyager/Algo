package LeetCode.Medium;

public class IsGraphBipartite {
    int[] parent;
    public boolean isBipartite(int[][] graph) {
        int N = graph.length;
        parent = new int[N];

        for (int i=0; i<N; i++) {
            parent[i] = i;
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<graph[i].length; j++) {
                if (find(i) == find(graph[i][j]))   //현재 노드와 인접 노드가 같은 그룹이면 실패
                    return false;
                union(graph[i][0], graph[i][j]);    //인접 노드끼리 그루핑
            }

        }

        return true;
    }

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY)
            return;

        parent[rootX] = rootY;
    }
}
