package coding;

import java.util.*;

public class TV220904B {
    //BOJ 1740
    public static void main(String[] args) {
        long answer = 0;
        int count = 0;
        long N = 10000000000L;

        while (N > 0) {
            if ((N & 1) == 1) {
                answer += pow(3, count);
            }
            count++;
            N = (N >> 1);
        }
        System.out.println(answer);

        Queue<Long> queue = new LinkedList<>();

        long n = 10000000000L;
        while (n != 0) {
            queue.add(n % 2);
            n /= 2;
        }

        long answer2 = 0;
        long mul = 1;

        while (!queue.isEmpty()) {
            answer2 += queue.poll() * mul;
            mul *= 3;
        }
        System.out.println(answer2);

        long pow = 1;
        long answer3= 0;
        String binary = Long.toBinaryString(10000000000L);
        for (int i=binary.length()-1; i>-1; i--) {
            int mod = binary.charAt(i) - '0';
            answer3 += mod * pow;
            pow *= 3;
        }
        System.out.println(answer3);

    }

    public static long pow(long x, long y) {
        if (y == 0) {
            return 1;
        }
        long res = pow(x, y / 2);

        if (y % 2 == 0) {
            return res * res;
        } else {
            return res * res * x;
        }
    }



}
