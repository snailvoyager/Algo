package HackerRank.Easy;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CaesarCipher {

	static String caesarCipher(String s, int k) {
        String alphaLow = "abcdefghijklmnopqrstuvwxyz";
        String alphaUpp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder result = new StringBuilder();

        char[] lowArr = alphaLow.toCharArray();
        char[] uppArr = alphaUpp.toCharArray();

        for(int i=0; i<s.length(); i++){
            char j = s.charAt(i);
            int idxLow = Arrays.binarySearch(lowArr, j);
            int idxUpp = Arrays.binarySearch(uppArr, j);
            
            if(idxLow >= 0){
                int enc = (idxLow + k) % 26;
                result.append(lowArr[enc]);
            } else if(idxUpp >= 0){
                int enc = (idxUpp + k) % 26;
                result.append(uppArr[enc]);
            } else{
                result.append(j);
            }
        }
        return result.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
