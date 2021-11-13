package LeetCode.Medium;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int answer = 0;

        /*for (int i=0; i<height.length-1; i++) {
            for (int j=i+1; j<height.length; j++) {
                int x = j - i;
                int y = height[i] > height[j] ? height[j] : height[i];
                int area = x * y;

                if (answer < area) {
                    answer = area;
                }
            }
        }*/

        int left = 0;
        int right = height.length -1 ;

        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);

            answer = Math.max(answer, (right-left)*minHeight);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }

        }

        return answer;
    }
}
