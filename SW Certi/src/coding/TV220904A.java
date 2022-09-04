package coding;

public class TV220904A {
    public int solution(int[][] office, int k) {
        int answer = 0;
        int N = office.length;

        for (int i=0; i<=N-k; i++) {
            for (int j=0; j<=N-k; j++) {
                answer = Math.max(answer, find(i, j, office, k));
            }
        }
        return answer;
    }

    public int find(int x, int y, int[][] office, int k) {
        int sum = 0;

        for (int i=x; i<x+k; i++) {
            for (int j=y; j<y+k; j++) {
                if (office[i][j] == 1) {
                    sum++;
                }
            }
        }
        return sum;
    }
}
