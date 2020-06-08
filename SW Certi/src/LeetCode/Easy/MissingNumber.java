package LeetCode.Easy;

import java.util.Arrays;

public class MissingNumber {
	public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for(; result<nums.length; result++){
            if(result != nums[result]){
                return result;
            }
        }
        return result;
    }
}
