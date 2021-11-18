package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        permute(arr);
    }

    static boolean[] Visited;
    static int[] Perm;
    public static List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> answer = new ArrayList<>();

        for (int i=0; i<nums.length; i++) {
            Visited = new boolean[nums.length];
            Perm = new int[nums.length];

            Perm[0] = nums[i];
            Visited[i] = true;
            addList(answer, nums, 1);
            Visited[i] = false;
        }

        return answer;
    }

    public static void addList(List<List<Integer>> answer, int[] nums, int n) {
        if (nums.length == n) {
            List<Integer> list = new ArrayList<>();
            for (int p:Perm) {
                list.add(p);
            }
            answer.add(list);
            System.out.println(Arrays.toString(Perm));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (!Visited[i]) {
                Perm[n] = nums[i];
                Visited[i] = true;
                System.out.println(n + ", " + Arrays.toString(Perm));
                addList(answer, nums, n+1);
                Visited[i] = false;
            }
        }
    }
}
