package LeetCode.Easy;

public class CountingBits {
    class Solution {
        public int[] countBits(int n) {
            int[] ans = new int[n+1];

            for(int i=0; i<n+1; i++) {
                int num = i;
                int mod = 0;
                int cnt = 0;

                while(num > 1){
                    mod = num % 2;
                    num = num / 2;
                    if (mod == 1) cnt++;

                }
                if (num == 1) cnt++;
                ans[i] = cnt;
            }
            return ans;
        }
    }
}
