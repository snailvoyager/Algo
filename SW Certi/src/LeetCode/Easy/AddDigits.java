package LeetCode.Easy;

public class AddDigits {
    public static void main(String[] args) {
        System.out.println(Integer.toString(10).length());
        System.out.println('8' - '0');

        System.out.println(addDigits(11));
    }

    public static int addDigits(int num) {
        String result = Integer.toString(num);

        while (result.length() > 1) {
            int a = 0;
            for (int i=0; i<result.length(); i++) {
                a += result.charAt(i) - '0';
            }
            result = Integer.toString(a);
        }

        return Integer.parseInt(result);
    }
}
