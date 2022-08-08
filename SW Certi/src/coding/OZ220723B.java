package coding;

public class OZ220723B {
    public int solution(int n) {
        int[] answer = new int[n+1];

        for (int i=1; i<=n; i++) {
            answer[i] = i;
            for (int j=1; j*j<=i; j++) {
                if (answer[i] > answer[i-j*j] + 1)
                    answer[i] = answer[i-j*j] + 1;
            }
        }
        return answer[n];
    }
}
