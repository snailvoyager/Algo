class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] answer = new int[2];
        
        answer[0] = findFirst(nums, target);
        answer[1] = findLast(nums, target);
               
        return answer;
    }
    
    public int findFirst(int[] nums, int target) {
        int result = -1;
        int start = 0;
        int end = nums.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                result = mid;
                end = mid - 1;
            }
        }
        return result;
    }
    
    public int findLast(int[] nums, int target) {
        int result = -1;
        int start = 0;
        int end = nums.length - 1;
        
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                result = mid;
                start = mid + 1;
            }
        }
        return result;
    }

}