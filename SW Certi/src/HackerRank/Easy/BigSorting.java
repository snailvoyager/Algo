package HackerRank.Easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class BigSorting {

	static String[] bigSorting(String[] unsorted) {

        Comparator<String> cp = new Comparator<String>(){
            public int compare(String s1, String s2){
                return compareString(s1, s2);
            }
        };
        Arrays.sort(unsorted, cp);
        return unsorted;
    }
	
	static int compareString(String s1, String s2) {
		if(s1.length() < s2.length())	return -1;
		if(s1.length() > s2.length())	return 1;
		
		//길이가 같으면
		for(int i=0; i<s1.length(); i++) {
			if(s1.charAt(i) < s2.charAt(i))
				return -1;
			if(s1.charAt(i) > s2.charAt(i))
				return 1;
		}
		
		return 0;
	}

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        String[] unsorted = new String[n];

        for (int i = 0; i < n; i++) {
            String unsortedItem = bufferedReader.readLine();
            unsorted[i] = unsortedItem;
        }

        String[] result = bigSorting(unsorted);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        bufferedReader.close();
    }

}
