package LeetCode.Easy;

public class RemoveDuplicatesfromSortedArray{
    
    public static int removeDuplicates(int[] nums) {
        int result = 0;
        
        for(int i=1; i<nums.length; i++){
            if(nums[i] > nums[i-1])
                nums[++result] = nums[i];
        }
        
        return ++result;
    }
    
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {1,2,3,4}));
        System.out.println(removeDuplicates(new int[] {0,0,1,1,2,2,3,3,4}));
    }
}

