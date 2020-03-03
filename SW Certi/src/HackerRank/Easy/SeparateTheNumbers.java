package HackerRank.Easy;

import java.util.Scanner;

public class SeparateTheNumbers {

	static void separateNumbers(String s) {
        int k = 1;
        int first = 0 ;

        for(int i=1; i<=s.length()-k; i++, k++){
            first = Integer.parseInt(s.substring(0, i));
            
            int next = Integer.parseInt(s.substring(i, i+k));
            
            if(first % 10 == 9)		//9 로 끝나는 정수는 k증가
            	next = Integer.parseInt(s.substring(i, i+k+1));

            if(next - first == 1){
                int before = next;
                int j =0 ;
                for(j=i+k; j<=s.length()-k; j+=k){
                    next = Integer.parseInt(s.substring(j, j+k));
                    if(next - before != 1)
                        break;
                    before = next;
                }
                if(j == s.length()){
                    System.out.println("YES " + first);
                    return;
                }
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
