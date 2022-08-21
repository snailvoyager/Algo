package coding;

public class II220821A {
    public static void main(String[] args) {
        System.out.println(digitSum(1990));
    }

    public static int solution(int N) {
        int sumN = digitSum(N);
        for (int i=N+1; i<=50000; i++) {
            int sumNum = digitSum(i);
            if (sumN == sumNum)
                return i;
        }
        return N;
    }

    public static int digitSum (int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}
