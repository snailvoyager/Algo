package Professional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_오른쪽과아래로만이동3_DP {
	static int T, Answer, N, M;
    static int[][] Mt, D;
    static int INF = 10000000;
 
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
             
            Mt = new int[N+1][M+1];
            D = new int[N+1][M+1];
             
            for(int i=1; i<=N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=M; j++) {
                    Mt[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            for(int i=0; i<=N; i++) {
                for(int j=0; j<=M; j++) {
                    if(i == 0 || j == 0)
                        D[i][j] = INF;
                    else if(i == 1 && j == 1)
                        D[i][j] = Mt[i][j];
                    else
                        D[i][j] = Math.min(D[i-1][j], D[i][j-1]) + Mt[i][j];
                }
            }
//          System.out.println(Arrays.deepToString(D));
            Answer = D[N][M];
             
            System.out.println("#"+test_case + " " + Answer);
        }
    }
}
/*
 * 다음처럼 각 칸에서 오른쪽이나 아래로만 움직일 수 있는 숫자판이 있습니다. 맨 왼쪽 위에서 오른쪽 아래로 이동할 때 지나는 칸에 적인 숫자의 합이 최소가 되도록 움직였다면, 이때의 합을 출력하세요.


입력
테스트케이스 수 T, 행의 수 N, 열의 수 M, 각 칸에 적힌 NxM개의 숫자 K가 차례로 주어진다.

3<=N, M<=100, 1<=K<=100
출력
#테스트케이스번호 합계

3
3 5
5 2 8 8 8 
4 4 8 5 8 
10 9 6 3 5 
4 5
10 3 3 2 2 
9 9 10 10 2 
8 8 4 1 1 
1 4 5 6 3
20 20
11 18 3 11 19 1 8 8 19 17 4 3 18 9 9 14 14 9 17 3 
11 6 8 10 17 10 10 5 11 18 15 8 15 4 9 1 12 18 15 5 
5 14 4 16 16 11 13 18 12 16 6 15 10 20 18 12 10 13 10 9 
20 1 4 9 5 14 8 1 4 13 11 9 12 18 2 1 20 13 9 19 
16 8 9 12 1 19 6 8 16 20 1 5 15 5 17 19 5 2 20 14 
16 3 1 16 15 5 8 2 16 20 5 8 6 1 8 3 8 13 12 18 
15 14 15 9 4 12 18 10 20 6 17 12 3 14 17 17 15 19 16 2 
19 14 5 6 3 15 16 19 1 16 12 16 1 2 11 3 2 11 6 9 
9 4 10 20 5 12 10 16 3 4 15 18 2 20 20 20 2 10 9 5 
14 2 5 16 16 18 11 2 9 11 2 17 8 11 5 6 11 16 18 7 
3 8 20 13 19 7 15 3 20 19 15 12 11 14 1 14 11 13 1 16 
5 10 19 1 18 15 20 9 8 17 19 19 15 12 13 16 13 9 18 19 
15 12 13 5 18 4 6 19 19 15 6 10 3 2 18 10 6 3 20 6 
20 17 2 6 8 14 16 6 4 12 13 15 1 14 12 20 9 15 9 15 
19 16 1 11 10 17 10 7 20 17 8 8 19 19 7 16 17 8 6 20 
12 11 15 20 2 14 1 20 15 9 14 17 7 7 12 20 14 13 18 1 
4 8 10 20 14 19 2 9 6 8 11 14 10 13 10 13 8 10 2 1 
5 1 4 5 19 19 9 4 19 5 9 4 19 12 16 9 16 13 10 20 
16 8 11 3 2 20 4 3 9 8 11 5 6 11 5 17 8 1 14 12 
10 20 8 19 16 14 3 8 18 9 17 9 18 6 6 11 10 3 14 9

#1 32
#2 26
#3 283
 */
