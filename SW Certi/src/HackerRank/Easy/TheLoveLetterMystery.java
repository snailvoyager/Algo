package HackerRank.Easy;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class TheLoveLetterMystery {
	static int theLoveLetterMystery(String s) {
        int half = s.length() / 2;
        int length = s.length();
        int result = 0;
        for(int i=0; i<half; i++){
            if(s.charAt(i) < s.charAt(length-1 - i))
                result += s.charAt(length-1-i) - s.charAt(i);
            else
                result += s.charAt(i) - s.charAt(length-1-i);
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = theLoveLetterMystery(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
