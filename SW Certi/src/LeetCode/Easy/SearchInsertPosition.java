package LeetCode.Easy;

public class SearchInsertPosition{
    public static int searchInsert(int[] nums, int target) {
        int i=0;
        for(; i<nums.length; i++){
            if(nums[i] == target)
                return i;
            if(nums[i] > target){
                if(i == 0)
                    return 0;
                else
                    return i;
            }
                
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[] {1,3,5,6}, 5));
        System.out.println(searchInsert(new int[] {1,3,5,6}, 2));
    }
}