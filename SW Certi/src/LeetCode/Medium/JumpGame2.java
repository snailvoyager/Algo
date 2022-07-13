package LeetCode.Medium;

public class JumpGame2 {
    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
        System.out.println(jump(new int[]{1,2,1,1,1}));
        System.out.println(jump(new int[]{0,1}));
        System.out.println(jump(new int[]{0}));
        System.out.println(jump(new int[]{1}));
        System.out.println(jump(new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3}));
        System.out.println();
        System.out.println(jump_solution(new int[]{2,3,1,1,4}));
        System.out.println(jump_solution(new int[]{1,2,1,1,1}));
        System.out.println(jump_solution(new int[]{0,1}));
        System.out.println(jump_solution(new int[]{0}));
        System.out.println(jump_solution(new int[]{1}));
        System.out.println(jump_solution(new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3}));
    }

    public static int jump(int[] nums) {
        if (nums.length == 1 || nums[0] == 0)
            return 0;

        int result = 0;
        int max = 0;

        for (int i=0; i<nums.length; i++) {
            int jumpIdx = i + nums[i];
            if (max < jumpIdx) {
                result++;
                max = jumpIdx;
            }
            if (jumpIdx >= nums.length-1)
                break;
        }
        return result;
    }

    public static int jump_solution (int[] nums) {
        int jumps = 0, curEnd = 0, farthestEnd = 0;

        for (int i=0; i<nums.length-1; i++) {
            farthestEnd = Math.max(farthestEnd, i + nums[i]);
            if (i == curEnd) {
                curEnd = farthestEnd;
                jumps++;
            }
        }

        return jumps;
    }

}
