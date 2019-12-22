package im;

import java.io.FileInputStream;
import java.util.Scanner;

public class IM0717 {

	static int[][] A = new int[10][10];
	static int N;
	static int[] Answer = new int[10];
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/im/im0717.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++){
			N = sc.nextInt();
			
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					A[i][j] = sc.nextInt();
				}
			}
			
			
			
			
			
			System.out.print("#"+test_case+ " ");
			for(int i=0; i<N; i++){
				System.out.print(Answer[i]+ " ");
			}
			System.out.println();
		}
	}

}
