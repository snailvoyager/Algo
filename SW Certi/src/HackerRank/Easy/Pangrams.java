package HackerRank.Easy;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Scanner;

public class Pangrams {

	static String pangrams(String s) {
        HashSet<Character> set = new HashSet<Character>();

        for(int i=0; i<s.length(); i++){
        	char c = s.charAt(i);
            if(c != ' ') {
            	if(c>=65 && c<=90)		//대문자라면 소문자로 변환
            		c += 32;
                set.add(c);
            }
        }

        if(set.size() == 26)
            return "pangram";
        else
            return "not pangram";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        String result = pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
