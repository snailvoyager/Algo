package HackerRank.Easy;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrongPassword {

	static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        
        int result = 0;

        Pattern numPattern = Pattern.compile("[0-9]");
        Matcher numMatcher = numPattern.matcher(password);
        if(!numMatcher.find())
            result++;
        
        Pattern lowPattern = Pattern.compile("[a-z]");
        Matcher lowMatcher = lowPattern.matcher(password);
        if(!lowMatcher.find())
            result++;

        Pattern uppPattern = Pattern.compile("[A-Z]");
        Matcher uppMatcher = uppPattern.matcher(password);
        if(!uppMatcher.find())
            result++;

        Pattern spcPattern = Pattern.compile("[!@#$%^&*()+-]");		// "-"는 범위지정으로 맨마지막에 둬야함
        Matcher spcMatcher = spcPattern.matcher(password);
        if(!spcMatcher.find())
            result++;

        return (result>(6-n)) ? result : (6-n);		//조건 부족한 수가 길이가 부족한 것보다 클수 있다. ex)0123 -> 3

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
