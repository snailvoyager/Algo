package ad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1065 {
	static int N, Answer;
	static char[] Arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		N = Integer.parseInt(str);
		int n = str.length();
		Arr = new char[n];
		
		if(N < 100) {
			System.out.println(N);
			return;
		}
		
		Answer += 99;
		for(int i=100; i<=N; i++) {
			Arr = Integer.toString(i).toCharArray();
			if(Arr[0] - Arr[1] == Arr[1] - Arr[2])
				Answer++;
		}
		System.out.println(Answer);
	}

}
