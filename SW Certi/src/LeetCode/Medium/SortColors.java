package LeetCode.Medium;

public class SortColors {
    public void sortColors(int[] nums) {
        //selectionSort(nums);

        //tow-pointers
        int first = 0;
        int last = nums.length-1;
        int i = 0;

        while (i <= last) {
            if (nums[i] == 0) {
                nums[i] = nums[first];
                nums[first] = 0;
                first++;
                i++;
            } else if (nums[i] == 2) {
                nums[i] = nums[last];
                nums[last] = 2;
                last--;
            } else {
                i++;
            }
        }
    }

    public void selectionSort(int[] nums) {
        for (int i=0; i<nums.length-1; i++) {
            int minIdx = i;
            for (int j=i+1; j<nums.length; j++) {
                //최소값 갱신
                if (nums[minIdx] > nums[j]) {
                    minIdx = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIdx];
            nums[minIdx] = temp;
        }
    }

    
}
