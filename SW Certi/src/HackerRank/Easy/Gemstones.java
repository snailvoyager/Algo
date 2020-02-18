package HackerRank.Easy;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Gemstones {

	static int gemstones(String[] arr) {
        int[] alpha = new int[26];
        Arrays.fill(alpha, -1);

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length(); j++){
                char mineral = arr[i].charAt(j);
                int idx = mineral % 97;
                
                if(alpha[idx] == i-1){      //i 이전에 저장이 됐으면
                    alpha[idx] = i;
                }
            }
        }

        int result = 0;
        for(int i : alpha){
            if(i == arr.length-1)
                result++;
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String arrItem = scanner.nextLine();
            arr[i] = arrItem;
        }

        int result = gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
