package im;

import java.util.Scanner;

public class IM_Juice1 {

	static int Answer, N;
	static int[] Juice;
	static int[][] Wish;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++){
			Answer = 0;
			N = sc.nextInt();
			Juice = new int[3];
			for(int i=0; i<3; i++){
				Juice[i] = sc.nextInt();
			}
			
			Wish = new int[N][3];
			for(int i=0; i<N; i++){
				Wish[i][0] = sc.nextInt();
				Wish[i][1] = sc.nextInt();
				Wish[i][2] = sc.nextInt();
			}
			
			for(int i=0; i<N; i++){
				int cnt = 0;
				
				if(Juice[0] >= Wish[i][0]){
					cnt++;
				}
				if(Juice[1] >= Wish[i][1]){
					cnt++;
				}
				if(Juice[2] >= Wish[i][2]){
					cnt++;
				}
				
				if(cnt == 3){
					Answer++;
				} else if(cnt == 2){
					if(Juice[0]>=Wish[i][0] && Juice[1]>=Wish[i][1]){
						if(Juice[2] + 500 >= Wish[i][2]){
							Answer++;
						}
					} else if(Juice[0]>=Wish[i][0] && Juice[2]>=Wish[i][2]){
						if(Juice[1] + 500 >= Wish[i][1]){
							Answer++;
						}
					} else if(Juice[1]>=Wish[i][1] && Juice[2]>=Wish[i][2]){
						if(Juice[0] + 500 >= Wish[i][0]){
							Answer++;
						}
					}
				}
			}
			
			System.out.println("#"+test_case+" "+Answer);
		}
	}

}
/*
2
3        
4000 3500 2500
3000 0 0
3000 2000 2500
5000 0 0
5        
8000 1500 500
7500 1500 500
8500 1000 500
9000 500 0
3000 2500 0
6000 2000 500

#1 2
#2 3
*/