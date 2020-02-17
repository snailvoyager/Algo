package HackerRank.Easy;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram {

	static int anagram(String s) {
        if(s.length() % 2 != 0)
            return -1;

        String subA = s.substring(0, s.length()/2); //두개 문자열로 자르기
        String subB = s.substring(s.length()/2);

        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();

        for(int i=0; i<s.length()/2; i++){          //두개 문자열 Map 저장
            char c1 = subA.charAt(i);
            char c2 = subB.charAt(i);
            int n1 = 0;
            int n2 = 0;
            if(mapA.containsKey(c1)){
                n1 = mapA.get(c1);
            } 
            if(mapB.containsKey(c2)){
                n2 = mapB.get(c2);
            }
            mapA.put(c1, ++n1);
            mapB.put(c2, ++n2);
        }

        int result = 0;
        for(int i=0; i<s.length()/2; i++){  //두개 문자열 비교
            char c1 = subA.charAt(i);
            int n1 = mapA.get(c1);
            
            if(mapB.containsKey(c1)) {		//B 문자열에 존재하면
            	int n2 = mapB.get(c1);
            	if(n2 > 0)
            		mapB.put(c1, --n2);		//1개 이상이면 갯수를 줄인다
            	else {
            		mapB.remove(c1);		//0개라면 제거하고 result 갯수 증가
            		result++;
            	}
            } else {
            	result++;			//B에 없으면 result 갯수증가
            }

        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = anagram(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }

}
