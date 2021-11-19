package programmers;

import java.util.*;

public class CP211031B {
    public static boolean[] prime;	// 소수를 체크할 배열
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(solution(999999999)));
        //System.out.println(Arrays.toString(solution2(20)));
        System.out.println(Arrays.toString(solution3(133L)));
    }

    public static long[] solution(long n) {
        long[] answer = {-1, -1};
        HashSet<Long> hashSet = new HashSet<>();

        outer :
        for (long i=0; i<=n; i++) {
            if (i < 2) {
                continue;
            }
            if (i == 2) {
                hashSet.add(i);
            }

           for (long j=2; j<=Math.sqrt(i); j++) {
               if (i % j == 0) {
                   continue outer;
               }
           }
           hashSet.add(i);
        }
        System.out.println(hashSet.toString());

        for (long p1 : hashSet) {
            long p2 = n / p1;
            if (n % p1 == 0 && p1 != p2) {
                if (hashSet.contains(p2)) {
                    answer[0] = p1;
                    answer[1] = p2;
                    Arrays.sort(answer);
                    return answer;
                }
            }
        }

        return answer;
    }

    public static long[] solution2(long n) {        //에라토스테네스의 체
        long[] answer = {-1, -1};
        HashSet<Long> hashSet = new HashSet<>();
        LinkedList<Boolean> list = new LinkedList<>();
        for (long i=0; i<=n; i++) {
            if (i == 0 || i== 1) {
                list.add(true);
            } else {
                list.add(false);
            }
        }

        for(int i=2; i<=Math.sqrt(n); i++) {
            if (list.get(i) == true) {
                continue;
            }
            for (int j=i*i; j<=n; j=j+i) {
                list.set(j, true);
            }
        }

        long idx = 0;
        for (boolean isPrime : list) {
            if (isPrime == false) {
                hashSet.add(idx);
            }
            idx++;
        }
        System.out.println(hashSet.toString());

        return answer;
    }

    public static long[] solution3(long n) {
        long[] answer = {-1, -1};
        //약수 구하기
        outer :
        for (long i=2; i<=n/2; i++) {
            if (n % i == 0) {       // 약수면 소수인지 체크
                long j = n / i;

                for (long k=2; k<=Math.sqrt(i); k++) {
                    if (i % k == 0) {
                        break outer;
                    }
                }
                for (long k=2; k<=Math.sqrt(j); k++) {
                    if (j % k == 0) {
                        break outer;
                    }
                }
                if (i != j) {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        Arrays.sort(answer);

        return answer;
    }

}
