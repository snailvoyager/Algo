package codility.iterations;

public class CyclicRotation {
    //https://app.codility.com/demo/results/trainingVCSMKX-G5C/
    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        int N = A.length;
        int[] answer = new int[N];

        for (int i=0; i<N; i++) {
            int newIdx = (i + K) % N;
            answer[newIdx] = A[i];
        }

        return answer;
    }
}
