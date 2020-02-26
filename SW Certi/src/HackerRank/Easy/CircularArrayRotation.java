package HackerRank.Easy;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class CircularArrayRotation {

	static int[] circularArrayRotation(int[] a, int k, int[] queries) {

        int[] result = new int[queries.length];
        int rot = k % a.length;
        for(int i=0; i<queries.length; i++){
            int idx = queries[i] - rot;
            if(idx < 0)
                idx += a.length;
            
            result[i] = a[idx];
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nkq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nkq[0]);

        int k = Integer.parseInt(nkq[1]);

        int q = Integer.parseInt(nkq[2]);

        int[] a = new int[n];

        //String[] aItems = scanner.nextLine().split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            //int aItem = Integer.parseInt(aItems[i]);
            //a[i] = aItem;
            a[i] = scanner.nextInt();
        }

        int[] queries = new int[q];

        for (int i = 0; i < q; i++) {
            int queriesItem = scanner.nextInt();
            //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        int[] result = circularArrayRotation(a, k, queries);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
