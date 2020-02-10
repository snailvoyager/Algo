package HackerRank.Easy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class PickingNumbers {
	
	public static int pickingNumbers(List<Integer> a) {
	    // Write your code here
	        int size = a.size();
	        List<Integer>[] subArr = new ArrayList[size];		//1 작은 값을 저장하는 인접리스트
	        List<Integer>[] subArr2 = new ArrayList[size];		//1 큰 값을 저장하는 인접리스트

	        for(int i=0; i<size; i++){
	            subArr[i] = new ArrayList<>();
	            subArr2[i] = new ArrayList<>();
	        }

	        for(int i=0; i<size; i++){
	            for(int j=0; j<size; j++){
	                if(a.get(i) == a.get(j) || a.get(i) == a.get(j)+1)  //1 작은것
	                    subArr[i].add(a.get(j));
	                if(a.get(i) == a.get(j) || a.get(i) == a.get(j)-1)  //1 큰것
	                    subArr2[i].add(a.get(j));
	            }
	        }

	        int max = 0;

	        for(int i=0; i<size; i++){
	            if(subArr[i].size() > max)
	                max = subArr[i].size();
	            if(subArr2[i].size() > max)
	                max = subArr2[i].size();
	        }

	        return max;
	    }

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aTemp[i]);
            a.add(aItem);
        }

        int result = pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
	}

}
