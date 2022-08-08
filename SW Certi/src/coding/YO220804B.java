package coding;

import java.util.Arrays;

public class YO220804B {
    public int solution(int[] A) {
        int result = 0;

        Arrays.sort(A);
        for (int i=0; i<A.length; i++){
            if (A[i] != i+1) {
                result += Math.abs(A[i] - (i+1));

                if (result > 1000000000)
                    return -1;
            }
        }
        return result;
    }
}
