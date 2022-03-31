package LeetCode.Easy;

import java.util.HashSet;

public class PerfectNumber {
    public static void main(String[] args) {
        System.out.println(Math.sqrt(28));
        System.out.println(Math.sqrt(56));
        System.out.println(Math.sqrt(49.2));
    }
    public boolean checkPerfectNumber_old(int num) {
        if (num == 1)
            return false;

        int sum = 1;
        HashSet<Integer> memo = new HashSet<>();

        for (int i=2; i<=num/2; i++) {
            if (memo.contains(i))
                break;

            if (num % i == 0) {
                sum += i;
                sum += num/i;

                memo.add(i);
                memo.add(num/i);
            }
        }
        return sum == num;
    }

    public boolean checkPerfectNumber (int num) {
        if (num == 1) return false;

        int sum = 1;
        for (int i=2; i<Math.sqrt(num); i++) {
            if (num % i ==0) {
                sum += i;
                if (i != num/i)
                    sum += num/i;
            }
        }


        return sum == num;
    }
}
