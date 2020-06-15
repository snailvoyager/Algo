package LeetCode.Easy;

public class MoveZeroes {
	public void moveZeroes(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(nums[i] == -1)
                break;
            
            if(nums[i] == 0){
                for(int j=i+1; j<nums.length; j++){
                    nums[j-1] = nums[j];        //한칸씩 이동
                }
                nums[nums.length -1] = -1;       //0은 끝으로 이동
                i = -1;          //다시 탐색
            }
            
        }
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] == -1)
                nums[i] = 0;
        }
    }
	
	public void moveZeroes2(int[] nums) {
	    if (nums == null || nums.length == 0) return;        

	    int insertPos = 0;
	    for (int num: nums) {
	        if (num != 0) nums[insertPos++] = num;
	    }        

	    while (insertPos < nums.length) {
	        nums[insertPos++] = 0;
	    }
	}
}
