package LeetCode.Easy;

public class MaximumSubarray{
    public static int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i=0; i<nums.length; i++){
            if(sum < 0)
                sum = nums[i];
            else
                sum += nums[i];
            
            if(sum > result)
                result = sum;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
}