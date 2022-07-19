package LeetCode.Medium;

import java.util.*;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(longestConsecutive(new int[]{1,2,0,1}));
    }
    public static int longestConsecutive_PQ(int[] nums) {
        int result = 0;
        if (nums.length < 1)
            return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : nums) {            //TC : O(N)
            pq.add(i);
        }

        int length = 1;
        int before = !pq.isEmpty() ? pq.poll() : 0;
        while (!pq.isEmpty()) {         //TC : O(N)
            int i = pq.poll();

            if (i == before)
                continue;

            if (i == before +1) {
                length++;
            } else {
                result = Math.max(result, length);
                length = 1;
            }
            before = i;
        }
        result = Math.max(result, length);

        return result;
    }

    public static int longestConsecutive(int[] nums) {
        parent = new int[nums.length];
        size = new int[nums.length];

        for (int i=0; i<nums.length; i++) {     //init
            parent[i] = i;
            size[i] = 1;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }
            if (map.containsKey(nums[i]-1)) {
                union(i, map.get(nums[i]-1));
            }
            if (map.containsKey(nums[i]+1)) {
                union(i, map.get(nums[i]+1));
            }
            map.put(nums[i], i);
        }

        int result = 0;
        for (int i=0; i<parent.length; i++) {
            if (parent[i] == i) {
                result = Math.max(result, size[i]);
            }
        }

        return result;
    }
    static int[] parent;
    static int[] size;

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    static void union(int x, int y) {
        int xP = find(x);
        int yP = find(y);

        if (xP != yP) {
            parent[xP] = yP;
            size[yP] += size[xP];
        }
    }
}
