package LeetCode.Medium;

public class HouseRobber {
    static int[][] memo;

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,1,1,2}));
        System.out.println(rob(new int[]{1,2,2,1}));
        System.out.println(rob(new int[]{2,7,9,3,1}));
        System.out.println(rob(new int[]{226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124}));
        System.out.println(rob(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
        System.out.println();
        System.out.println(rob2(new int[]{2,1,1,2}));
        System.out.println(rob2(new int[]{1,2,2,1}));
        System.out.println(rob2(new int[]{2,7,9,3,1}));
        System.out.println(rob2(new int[]{226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124}));
        System.out.println(rob(new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
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

    public static int rob2(int[] nums) {
        int[] memo = new int[nums.length+1];
        memo[0] = 0;
        memo[1] = nums[0];

        for (int i=1; i<nums.length; i++) {
            memo[i+1] = Math.max(memo[i], memo[i-1] + nums[i]);
        }

        return memo[nums.length];
    }
}
