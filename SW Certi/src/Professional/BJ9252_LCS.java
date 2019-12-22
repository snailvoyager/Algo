package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ9252_LCS {

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
//		System.out.println(Arrays.deepToString(Map));
		
		String LCS = "";
		int temp1 = Map[lengthA][lengthB];
		int temp0 = temp1 - 1;
		int for_j = lengthB;
		
		for(int i=lengthA; i>0; i--){
			for(int j=for_j; j>0; j--){
				if(Map[i][j] == temp1 && Map[i-1][j] == temp0 
						&& Map[i-1][j-1] == temp0 && Map[i][j-1] == temp0){
					LCS = strA.charAt(i-1) + LCS;
					temp1 --;
					temp0 --;
					for_j = j-1;
					break;
				}
			}
		}
		System.out.println(LCS);
	}
}
