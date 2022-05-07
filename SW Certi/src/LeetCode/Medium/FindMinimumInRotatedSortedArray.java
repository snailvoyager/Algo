package LeetCode.Medium;

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int f = 0;
        int r = nums.length - 1;
        int m = r/2;

        if (nums[f] < nums[r])
            return nums[f];

        while (f < m) {
            if (nums[f] > nums[m]) {
                r = m;
                m = f + (r-f)/2;
            } else {
                f = m;
                m = f + (r-f)/2;
            }
        }
        return nums[m] > nums[r] ? nums[r] : nums[m];
    }
}
