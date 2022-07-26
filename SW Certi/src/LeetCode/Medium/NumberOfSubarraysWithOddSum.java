package LeetCode.Medium;

public class NumberOfSubarraysWithOddSum {
    public static int solution_fail(int[] arr) {        //subarray를 부분집합으로 잘못 이해함.
        int answer = 0;
        for (int i=0; i<(1<<arr.length); i++) {
            int sum = 0;
            for (int j=0; j<arr.length; j++) {
                if ((i & (1<<j)) != 0) {
                    sum += arr[j];
                }
                if (sum > 1000000007)
                    sum = sum%1000000007;
            }
            if (sum % 2 == 1)
                answer++;
        }
        return answer;
    }

    public static int solution_timeout(int[] arr) {
        int answer = 0;

        for (int i=0; i<arr.length; i++) {          //O(N^2)
            int sum = 0;
            for (int j=i; j<arr.length; j++) {
                sum += arr[j];
                if (sum % 2 == 1)
                    answer++;
            }
        }

        return answer;
    }

    public static int solution(int[] arr) {         //using Prefix Sum
        int answer = 0;
        int odd = 0, even = 1, sum = 0;

        for (int n : arr) {
            sum += n;
            if (sum % 2 == 0) {
                even++;
                answer = (answer + odd) % 1000000007;
            } else {
                odd++;
                answer = (answer + even) % 1000000007;
            }
        }

        return answer;
    }
}
