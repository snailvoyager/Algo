package LeetCode.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 7, 11, 15,1};
		int target = 9;
		//int[] nums = {3, 2, 4};
		//int target = 6;
		
		nums = twoSum2(nums, target);
		
		System.out.println(Arrays.toString(nums));
	}
	
	public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int size = nums.length;
        
        for(int i=0; i<size; i++) {
        	int reg = target - nums[i];
        	
        	for(int j=i+1; j<size; j++) {
        		if(nums[j] == reg) {
        			result[0] = i;
        			result[1] = j;
        			break;
        		}
        	}
        }
        return result;
    }
	
	public static int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> hashmap = new HashMap<>();
		
		for(int i=0; i<nums.length; i++) {
			hashmap.put(nums[i], i);
		}
		
		for(int i=0; i<nums.length; i++) {
			int reg = target - nums[i];
			if(hashmap.containsKey(reg) && reg != nums[i])
				return new int[] {i, hashmap.get(reg)};
		}
		throw new IllegalArgumentException("No two sum solution");
	}

}
