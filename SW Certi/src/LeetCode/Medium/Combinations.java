package LeetCode.Medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    static int[] N;
    static int[] T;
    static boolean[] V;
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        N = new int[n];
        T = new int[k];
        V = new boolean[n];

        for (int i=0; i<n; i++) {
            N[i] = i+1;
        }

        //recur(n, k, result);
        recur2(n, k, 0, result);
        //recur3(n, k, 0, result);

        return result;
    }

    public void recur3(int n, int k, int start, List<List<Integer>> result) {
        if (k == 0) {
            List<Integer> list = new ArrayList<>();
            for (int j : T)
                list.add(j);
            result.add(list);
            return;
        }

        for (int i=start; i<n; i++) {
            T[k-1] = N[i];
            recur3(n, k-1, i+1, result);
        }
    }

    public void recur(int n, int k, List<List<Integer>> result) {
        if (k == 0) {
            List<Integer> list = new ArrayList<>();
            for (int j : T)
                list.add(j);
            result.add(list);
            return;
        } else if (n < k) {
            return;
        }

        T[k-1] = N[n-1];
        recur(n-1, k-1, result);
        recur(n-1, k, result);
    }

    public void recur2(int n, int k, int start, List<List<Integer>> result) {
        if (k == 0) {
            List<Integer> list = new ArrayList<>();
            for (int i=0; i<n; i++) {
                if (V[i])
                    list.add(N[i]);
            }

            result.add(list);
            return;
        }

        for (int i=start; i<n; i++) {
            V[i] = true;
            recur2(n, k-1, i+1, result);
            V[i] = false;
        }
    }
}
