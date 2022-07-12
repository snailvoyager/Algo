package LeetCode.Medium;

public class JumpGame {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
        System.out.println(canJump(new int[]{2,0}));
        System.out.println(canJump(new int[]{1,2,3}));

        int[] arr = new int[1<<10];
        for (int i=0; i<(1<<10); i++) {
            arr[i] = 999;
        }
        System.out.println(canJump_solution(arr));
        System.out.println(canJump(arr));
    }

    public static boolean canJump_solution (int[] A) {
        int max = 0;
        for(int i=0;i<A.length;i++){
            if(i>max) {return false;}
            max = Math.max(A[i]+i,max);
        }
        return true;
    }

    public static boolean canJump(int[] nums) {
        return nextJump(0, nums);
    }

    public static boolean nextJump(int idx, int[] nums) {
        if (idx == nums.length-1)
            return true;
        else if (idx > nums.length-1)
            return false;
        else {
            if (nums[idx] == 0)
                return false;

            boolean result = false;
            for (int i=nums[idx]; i > 0; i--) {
                if (idx + i > nums.length -1)
                    continue;

                result = nextJump(idx + i, nums);
                if (result)
                    break;
                else
                    nums[idx+i] = 0;
            }
            return result;
        }
    }
}
