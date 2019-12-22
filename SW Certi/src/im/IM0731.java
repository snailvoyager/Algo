package im;

import java.io.FileInputStream;
import java.util.Scanner;

public class IM0731 {

	static int N=20;
	static int[][] map = new int[N][N];
	static int AnswerN;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/im/im0731.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++){
			AnswerN = 0;
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					map[i][j] = sc.nextInt();
				}
			}
			
			
			
			
			System.out.println("#"+test_case+" "+AnswerN);
		}
	}

}
