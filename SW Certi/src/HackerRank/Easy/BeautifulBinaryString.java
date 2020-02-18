package HackerRank.Easy;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BeautifulBinaryString {

	static int beautifulBinaryString(String b) {
        int idx = 0;
        int result = 0;

        while(idx > -1){
            idx = b.indexOf("010");
            if(idx < 0)
                break;
            idx += 3;
            b = b.substring(idx);
            result++;
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String b = scanner.nextLine();

        int result = beautifulBinaryString(b);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
