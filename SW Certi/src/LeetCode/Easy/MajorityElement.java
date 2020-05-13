package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	class Solution {
	    public int majorityElement(int[] nums) {

	        Map<Integer, Integer> map = new HashMap<>();
	        for(int i : nums){
	            if(map.containsKey(i)){     //키가 존재하면 증가
	                int cnt = map.get(i);
	                map.put(i, ++cnt);
	            } else{
	                map.put(i, 1);
	            }
	        }
	        
	        int majority = nums.length / 2;
	        for(int i : nums){
	            if(map.get(i) > majority)
	                return i;
	        }
	        return 0;
	    }
	}
}
