package coding;

public class YO220804A {
    public static void main(String[] args) {
        int N = 1;
        int cnt = 0;

        while (N > 9) {
            N = N / 10;
            cnt++;
        }

        int result = 0;

        System.out.println((int)Math.pow(10, cnt));
    }

    public int solution(int N) {
        int cnt = 0;
        while (N > 9) {
            N = N / 10;
            cnt++;
        }
        return cnt == 0 ? 0 : (int)Math.pow(10, cnt);
    }
}
