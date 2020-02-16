package HackerRank.Easy;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WeightedUniformStrings {

	static String[] weightedUniformStrings(String s, int[] queries) {
        String[] result = new String[queries.length];
        List<Integer> list = new ArrayList<Integer>();

        char first = s.charAt(0);
        list.add(first % 96);

        StringBuilder sb = new StringBuilder();     //substring 저장
        sb.append(first);

        for(int i=1; i<s.length(); i++){
            char before = s.charAt(i-1);
            char now = s.charAt(i);

            if(before == now){
                sb.append(now);
                list.add((now % 96) * sb.length()); //uniform 갯수만큼
            } else{
                sb = new StringBuilder();           //substring 새로 시작
                sb.append(now);
                list.add(now % 96);
            }
        }
        Collections.sort(list);             //search를 위해 정렬, list.contains로 찾으면 시간초과
        for(int i=0; i<queries.length; i++){
            if(Collections.binarySearch(list, queries[i]) > -1)
                result[i] = "Yes";
            else
                result[i] = "No";
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        String[] result = weightedUniformStrings(s, queries);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
