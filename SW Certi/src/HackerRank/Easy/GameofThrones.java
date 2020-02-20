package HackerRank.Easy;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class GameofThrones {

	static String gameOfThrones(String s) {
        int[] alpha = new int[26];
        Arrays.fill(alpha, 0);

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int idx = c % 97;
            alpha[idx]++;			//알파벳 별로 카운팅
        }

        int odd = 0;
        for(int i : alpha){
            if(i % 2 != 0)			//홀수 카운팅
                odd++;
        } 

        if(odd > 1)
            return "NO";			//홀수가 2개부터는 회문 불가
        else
            return "YES";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        String result = gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
