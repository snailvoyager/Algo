package LeetCode.Medium;

import java.util.Arrays;
import java.util.HashSet;

public class FindTheDuplicateNumber {
    public int findDuplicate_memo(int[] nums) {
        boolean[] isTrue = new boolean[nums.length];

        for (int i=0; i<nums.length; i++) {     //O(N)
            if (isTrue[nums[i]]) {
                return nums[i];
            } else {
                isTrue[nums[i]] = true;
            }
        }
        return -1;
    }

    public int findDuplicate_set(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {        //O(N)
            if (set.contains(i)) {
                return i;
            } else {
                set.add(i);
            }
        }
        return -1;
    }

    public int findDuplicate_sort(int[] nums) {
        Arrays.sort(nums);      //O(N logN)

        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return nums[i];
            }
        }
        return -1;
    }
}
