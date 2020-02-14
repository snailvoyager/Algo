package HackerRank.Easy;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class HackerrankInString {

	static String hackerrankInString(String s) {
        String subseq = "hackerrank";
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        for(int i=0; i<subseq.length(); i++){
            char c = subseq.charAt(i);

            while(idx < s.length()){
                if(s.charAt(idx) == c){
                    sb.append(s.charAt(idx));
                    idx++;
                    break;
                }
                idx++;
            }
        }
        if(subseq.equals(sb.toString()))
            return "YES";
        else
            return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = hackerrankInString(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }

}
