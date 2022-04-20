package LeetCode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {
    static boolean[] Visited;
    static int[] Perm;
    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);

        Visited = new boolean[nums.length];
        Perm = new int[nums.length];

        addList(answer, nums, 0);

        return answer;
    }

    public void addList(List<List<Integer>> answer, int[] nums, int n) {
        if (nums.length == n) {
            List<Integer> list = new ArrayList<>();
            for (int p:Perm) {
                list.add(p);
            }
            answer.add(list);
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (!Visited[i]) {
                if (i>0 && nums[i-1] == nums[i] && !Visited[i-1])
                    continue;
                Perm[n] = nums[i];
                Visited[i] = true;
                addList(answer, nums, n+1);
                Visited[i] = false;
            }
        }
    }
}
