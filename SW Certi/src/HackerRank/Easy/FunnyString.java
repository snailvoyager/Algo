package HackerRank.Easy;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class FunnyString {

	static String funnyString(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>-1; i--)
            sb.append(s.charAt(i));
        String r = sb.toString();

        int[] diffS = new int[s.length()-1];
        int[] diffR = new int[r.length()-1];

        for(int i=0; i<s.length()-1; i++){
            diffS[i] = Math.abs(s.charAt(i) - s.charAt(i+1));
            diffR[i] = Math.abs(r.charAt(i) - r.charAt(i+1));
        }

        String funnyS = Arrays.toString(diffS);
        String funnyR = Arrays.toString(diffR);

        if(funnyS.equals(funnyR))
            return "Funny";
        else
            return "Not Funny";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = funnyString(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }

}
