package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_0이연속되지않는n자리자연수_DP {
	 static int T, Answer, N;
	    static int[][] D;
	 
	    public static void main(String[] args) throws NumberFormatException, IOException {
	        // TODO Auto-generated method stub
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st;
	         
	        T = Integer.parseInt(br.readLine());
	        for(int test_case=1; test_case<=T; test_case++) {
	            Answer = 0;
	            N = Integer.parseInt(br.readLine());
	            D = new int[2][N+1];
	             
	            D[0][1] = 0;			//첫번째가 0으로 시작하는 경우의 수
	            D[1][1] = 1;			//첫번째가 1로 시작하는 경우의 수
	            for(int i=2; i<=N; i++) {
	                D[0][i] = D[1][i-1];			//앞에 1이 있으면 0이 올 수 있음
	                D[1][i] = D[0][i-1] + D[1][i-1];	//앞에 1이든 0이든 항상 1이 올 수 있음. 
	            }
	             
	            Answer = D[0][N] + D[1][N];
	             
	            System.out.println("#"+test_case + " " + Answer);
	        }
	    }
}
/*
1로 시작하는 n비트 이진수에서 0이 연속으로 나타나지 않는 경우의 수를 구하시오.

입력
3<=n<=30

테스트 케이스 개수와 각 케이스 별로 n이 주어집니다.

출력
#테스트케이스 번호와 경우의 수를 출력합니다.

3
4
8
10

#1 5
#2 34
#3 89

*/