package HackerRank.Easy;

import java.util.Scanner;

public class SeparateTheNumbers {

	static void separateNumbers(String s) {
		if(s.charAt(0) == '0') {
			System.out.println("NO");
			return;
		}
        for(int i=1; i<=s.length()/2; i++) {
        	String first = s.substring(0, i);
        	long start = Long.parseLong(first);		// |s|<=32 !!! Integer.MAX_VALUE = 2147483647
        	
        	StringBuilder sb = new StringBuilder();
        	sb.append(first);
        	while(sb.length() < s.length()) {
        		sb.append(++start);
        	}
        	
        	if(sb.toString().equals(s)) {
        		System.out.println("YES " + first);
        		return;
        	}
        }
        System.out.println("NO");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            separateNumbers(s);
        }

        scanner.close();
    }

}
