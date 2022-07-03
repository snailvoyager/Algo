package LeetCode.Medium;

public class HouseRobber {
    static int[][] memo;

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,1,1,2}));
        System.out.println(rob(new int[]{1,2,2,1}));
        System.out.println(rob(new int[]{2,7,9,3,1}));
        System.out.println(rob(new int[]{1,2}));
    }

    public static int rob(int[] nums) {
        memo = new int[nums.length][2];
        return Math.max(recur(nums, 0), recur(nums, 1));
    }

    public static int recur(int[] nums, int idx) {
        if (idx >= nums.length) {
            return 0;
        }
        if (memo[idx][0] == 0) {
            memo[idx][0] = 1;       //visited;
            memo[idx][1] = nums[idx] + Math.max(recur(nums, idx+2), recur(nums, idx+3));
        }
        return memo[idx][1];
    }
}
