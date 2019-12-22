package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9251_LCS {

	static String strA, strB;
	static int[][] Map;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		strA = br.readLine();
		strB = br.readLine();
		int lengthA = strA.length();
		int lengthB = strB.length();
		
		Map = new int[lengthA + 1][lengthB + 1];
		for(int i=1; i<=lengthA; i++){
			for(int j=1; j<=lengthB; j++){
				if(strA.charAt(i-1) == strB.charAt(j-1)){
					Map[i][j] = Map[i-1][j-1] + 1;
				} else{
					Map[i][j] = Math.max(Map[i-1][j], Map[i][j-1]);
				}
				
			}
		}
		System.out.println(Map[lengthA][lengthB]);
	}

}
