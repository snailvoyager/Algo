package LeetCode.Medium;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGame3 {
    boolean[] visited;

    public boolean canReach(int[] arr, int start) {
        visited = new boolean[arr.length];

        return dfs(arr, start);
    }

    public boolean dfs(int[] arr, int idx) {
        if (arr[idx] == 0)
            return true;

        if (!visited[idx]) {
            visited[idx] = true;

            if (idx + arr[idx] < arr.length) {
                if (dfs(arr, idx + arr[idx]))
                    return true;
            }

            if (idx - arr[idx] > -1) {
                return dfs(arr, idx - arr[idx]);
            }
        }
        return false;
    }

    public boolean bfs(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int idx = q.poll();

            if (visited[idx])
                continue;
            if (arr[idx] == 0)
                return true;

            visited[idx] = true;

            if (idx + arr[idx] < arr.length) {
                q.offer(idx + arr[idx]);
            }
            if (idx - arr[idx] > -1) {
                q.offer(idx - arr[idx]);
            }
        }
        return false;
    }
}
