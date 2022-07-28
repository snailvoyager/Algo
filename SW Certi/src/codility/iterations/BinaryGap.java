package codility.iterations;

public class BinaryGap {
    //https://app.codility.com/demo/results/trainingHJFG2Q-9H8/
    public static void main(String[] args) {
        System.out.println(solution(328));
        System.out.println(solution(Integer.parseInt("10100001", 2)));
    }
    public static int solution(int N) {
        int result = 0;
        String binary = Integer.toBinaryString(N);

        int length = 0;

        for(int i=0; i<binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                result = Math.max(result, length);
                length = 0;
            } else {
                length++;
            }
        }
        return result;
    }
}
