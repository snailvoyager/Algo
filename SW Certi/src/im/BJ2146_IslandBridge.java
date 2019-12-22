package im;

import java.io.FileInputStream;
import java.util.Scanner;

public class BJ2146_IslandBridge {

	static int Answer, N;
	static int[][] M;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("src/im/bj2146.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = new int[N][N];
		
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				M[i][j] = sc.nextInt();
			}
		}
		
		loop1:
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(M[i][j] == 1){
					dfs();
					break loop1;
				}
			}
		}
		
		
		
		System.out.println(Answer);
	}
	
	public static void dfs(){
		
	}

}
