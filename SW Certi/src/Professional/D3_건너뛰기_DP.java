package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_건너뛰기_DP {
	static int T, Answer, N, M;
    static int[][] A, D;
 
    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        T = Integer.parseInt(br.readLine());
        for(int test_case=1; test_case<=T; test_case++) {
            Answer = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
             
            A = new int[N+1][M+1];
            D = new int[N+1][M+1];
             
            for(int i=1; i<=N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=M; j++) {
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            D[1][1] = 1;
             
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=M; j++) {
                    for(int k=1; k<=j-1; k++) {		//왼쪽에서 올 수 있는 경우
                        if(A[i][k] == j-k)
                            D[i][j] += D[i][k];
                    }
                     
                    for(int k=1; k<=i-1; k++) {		//위에서 올 수 있는 경우
                        if(A[k][j] == i-k)
                            D[i][j] += D[k][j];
                    }
                }
            }
             
            Answer = D[N][M];
             
            System.out.println("#"+test_case + " " + Answer);
        }
    }
}
/*
NxM 크기의 숫자판에는 각 칸에서 오른쪽이나 아래쪽으로 건너뛸 수 있는 숫자가 적혀있습니다. 맨 왼쪽위에서 출발 해 맨 오른쪽 아래칸에 정확하게 도착하는 경우의 수를 출력하세요.  
입력
테스트케이스 개수와 N, M, 각 칸의 숫자 a가 주어집니다.

1<T<=10, 5<=N, M<=20, 1<=a<=3

출력
#테스트케이스 번호와 답을 출력합니다.

3
5 5
2 3 1 3 1 
2 1 1 1 1 
3 1 2 1 3 
3 1 2 3 2 
3 1 2 3 2 
5 5
2 1 2 3 3 
1 1 2 3 1 
1 3 1 2 1 
2 2 1 2 3 
2 3 2 2 3 
5 10
1 1 1 1 1 2 1 2 3 2 
1 1 2 1 2 3 3 2 3 2 
2 1 3 2 3 1 2 1 2 1 
2 2 3 2 1 3 2 1 3 3 
1 2 1 3 3 2 3 3 3 3

#1 1
#2 2
#3 12
*/