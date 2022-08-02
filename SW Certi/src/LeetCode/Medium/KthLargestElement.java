package LeetCode.Medium;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        System.out.println("result : " + findKthLargest(new int[]{2,1,3,5,6,6}, 3));
    }
    public static int findKthLargest(int[] nums, int k) {
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1<o2 ? 1 : -1 );

        for (int i : nums) {
            pq.add(i);
        }
        for (int i=0; i<nums.length && !pq.isEmpty(); i++) {
            int n = pq.poll();
            if (i == k-1) {
                result = n;
                break;
            }
        }
        return result;
    }
}
