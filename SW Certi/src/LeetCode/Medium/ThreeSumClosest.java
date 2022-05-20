package LeetCode.Medium;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] nums = {13,2,0,-14,-20,19,8,-5,-13,-3,20,15,20,5,13,14,-17,-7,12,-6,0,20,-19,-1,-15,-2,8,-2,-9,13,0,-3,-18,-9,-9,-19,17,-14,-19};
        System.out.println(threeSumClosest(nums, -59));

        int[] nums2 = {1,2,4,8,16,32,64,128};
        System.out.println(threeSumClosest(nums2, 82));
    }

    public static int threeSumClosest_bitmask(int[] nums, int target) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int min = Integer.MAX_VALUE;
        int result = 0;

        for (int i=0; i<(1<<nums.length); i++) {        //2^31 초과 불가
            if (Integer.bitCount(i) == 3) {
                int sum = 0;
                for (int j=0; j<nums.length; j++) {
                    if ((i & (1<<j)) != 0) {
                        sum += nums[j];
                    }
                }
                if (Math.abs(target-sum) < min) {
                    min = Math.abs(target-sum);
                    result = sum;
                    System.out.println(Integer.toBinaryString(i));
                }
            }

        }
        return result;
    }

    public static int threeSumClosest_for(int[] nums, int target) {
        int result = 0;
        int sumMin =  Integer.MAX_VALUE;

        Arrays.sort(nums);

        for (int i=0; i<nums.length-2; i++) {       //O(N^3)
            for (int j=i+1; j<nums.length-1; j++) {
                for (int k=j+1; k<nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];

                    if (Math.abs(target - sum) < sumMin) {
                        result = sum;
                        sumMin = Math.abs(target - sum);
                        System.out.println(nums[i] + "," + nums[j] + "," + nums[k]);
                    } else {
                        //break;
                    }

                }
            }
        }

        return result;
    }

    public static int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length-1];
        Arrays.sort(nums);

        for (int i=0; i<nums.length-2; i++) {       //O(N^2)
            int start = i+1;
            int end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];

                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(target - sum) < Math.abs(target - result)) {
                    result = sum;
                }
            }

        }

        return result;
    }
}
